package com.example.AvaliacaoSpring.service;

import com.example.AvaliacaoSpring.dto.ArtigoInputDTO;
import com.example.AvaliacaoSpring.dto.ArtigoOutputDTO;
import com.example.AvaliacaoSpring.dto.AutorInputDTO;
import com.example.AvaliacaoSpring.model.Artigo;
import com.example.AvaliacaoSpring.model.Autor;
import com.example.AvaliacaoSpring.model.Revista;
import com.example.AvaliacaoSpring.repository.ArtigoRepository;
import com.example.AvaliacaoSpring.repository.AutorRepository;
import com.example.AvaliacaoSpring.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArtigoService {

    @Autowired
    private RevistaRepository revistaRepository;

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    public ArtigoOutputDTO findById(Long id) {
        Optional<Artigo> artigo = artigoRepository.findById(id);
        if (artigo.isPresent()) {
            return new ArtigoOutputDTO(artigo.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artigo não encontrado");
        }
    }

    public List<ArtigoOutputDTO> list() {

        List<Artigo> artigos = artigoRepository.findAll();
        List<ArtigoOutputDTO> artigosOutputDTO = new ArrayList<>();

        for (Artigo artigo : artigos) {
            artigosOutputDTO.add(new ArtigoOutputDTO(artigo));
        }

        return artigosOutputDTO;

    }

    public ArtigoOutputDTO create (ArtigoInputDTO artigoInputDTO){

        try{
            Artigo artigo = artigoInputDTO.build((revistaRepository));
            artigo.setAno(artigoInputDTO.getAno());
            artigo.setAutores(encontrarAutores(artigoInputDTO.getAutores()));
            artigo.setRevista(revistaRepository.findByNome(artigoInputDTO.getRevista()));

            for(Autor autor : artigo.getAutores()){
                autor.getArtigos().add(artigo);
            }

            Artigo artigoNoBD = artigoRepository.save(artigo);
            ArtigoOutputDTO artigoOutputDTO = new ArtigoOutputDTO(artigoNoBD);

            return artigoOutputDTO;
        }catch (Exception e){
            return null;
        }
    }

    public ArtigoOutputDTO update(Long id, ArtigoInputDTO artigoInputDTO) {
        Optional<Artigo> possivelArtigo = artigoRepository.findById(id);

        if (possivelArtigo.isPresent()) {
            Artigo artigoEncontrado = possivelArtigo.get();

            artigoEncontrado.setTitulo(artigoInputDTO.getTitulo());

            artigoEncontrado.setAno(artigoInputDTO.getAno());

            Set<Autor> autoresAtuais = encontrarAutores(artigoInputDTO.getAutores());
            for(Autor autor : artigoEncontrado.getAutores()){
                if(!autoresAtuais.contains(autor)){
                    autor.getArtigos().remove(artigoEncontrado);
                }
            }

            artigoEncontrado.setAutores(autoresAtuais);
            for(Autor autor : artigoEncontrado.getAutores()){
                autor.getArtigos().add(artigoEncontrado);
            }

            // Verifica se o revista existe
            Revista revista = revistaRepository.findByNome(artigoInputDTO.getRevista());
            if (revista == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Revista não encontrada");
            }

            artigoEncontrado.setRevista(revista);

            Artigo artigoAtualizado = artigoRepository.save(artigoEncontrado);

            return new ArtigoOutputDTO(artigoAtualizado);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artigo não encontrado");
        }
    }

    public void delete(Long id) {
        if (artigoRepository.existsById(id)) {
            artigoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artigo não encontrado");
        }
    }

    private Set<Autor> encontrarAutores(Set<AutorInputDTO> autores){
        return  autores.stream()
                .map(autor ->
                autorRepository.findAutorEspecifico(autor.getNome(), autor.getAfiliacao()))
                .collect(Collectors.toSet());
    }
}
