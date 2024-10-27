package com.example.AvaliacaoSpring.service;

import com.example.AvaliacaoSpring.dto.AutorInputDTO;
import com.example.AvaliacaoSpring.dto.AutorOutputDTO;
import com.example.AvaliacaoSpring.model.Autor;
import com.example.AvaliacaoSpring.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public AutorOutputDTO findById(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return new AutorOutputDTO(autor.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        }
    }

    public List<AutorOutputDTO> list() {

        List<Autor> autores = autorRepository.findAll();
        List<AutorOutputDTO> autoresOutputDTO = new ArrayList<>();

        for (Autor autor : autores) {
            autoresOutputDTO.add(new AutorOutputDTO(autor));
        }

        return autoresOutputDTO;

    }

    public AutorOutputDTO create(AutorInputDTO autorInputDTO) {

        try {
            Autor autor = new Autor();
            autor.setNome(autorInputDTO.getNome());
            autor.setAfiliacao(autorInputDTO.getAfiliacao());
            autor.setArtigos(autorInputDTO.getArtigos());

            Autor novoAutor = autorRepository.save(autor);

            AutorOutputDTO autorOutputDTO = new AutorOutputDTO(novoAutor);

            return autorOutputDTO;
        } catch (Exception e) {
            return null;
        }
    }

    public AutorOutputDTO update(Long id, AutorInputDTO autorInputDTO){
        Optional<Autor> possivelAutor = autorRepository.findById(id);

        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();

            autorEncontrado.setNome(autorInputDTO.getNome());
            autorEncontrado.setAfiliacao(autorInputDTO.getAfiliacao());
            autorEncontrado.setArtigos(autorInputDTO.getArtigos());

            Autor autorAtualizado = autorRepository.save(autorEncontrado);

            return new AutorOutputDTO(autorAtualizado);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artigo não encontrado");
        }
    }

    public void delete(Long id){
        if(autorRepository.existsById(id)){
            autorRepository.deleteById(id);
        }else{
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        }
    }
}
