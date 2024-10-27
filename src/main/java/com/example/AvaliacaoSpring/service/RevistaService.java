package com.example.AvaliacaoSpring.service;

import com.example.AvaliacaoSpring.dto.RevistaInputDTO;
import com.example.AvaliacaoSpring.dto.RevistaOutputDTO;
import com.example.AvaliacaoSpring.model.Revista;
import com.example.AvaliacaoSpring.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RevistaService {

    @Autowired
    private RevistaRepository revistaRepository;

    public RevistaOutputDTO findById(Long id){
        Optional<Revista> revista = revistaRepository.findById(id);
        if (revista.isPresent()){
            return new RevistaOutputDTO(revista.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Revista não encontrada");
        }
    }

    public List<RevistaOutputDTO> list(){
        List<Revista> revistas = revistaRepository.findAll();
        List<RevistaOutputDTO> revistasOutputDTO = new ArrayList<>();

        for(Revista revista : revistas){
            revistasOutputDTO.add(new RevistaOutputDTO(revista));
        }
        return revistasOutputDTO;
    }

    public RevistaOutputDTO create(RevistaInputDTO revistaInputDTO){

        try{
            Revista revista = new Revista();
            revista.setNome(revistaInputDTO.getNome());
            revista.setISSN(revistaInputDTO.getISSN());
            revista.setArtigos(revistaInputDTO.getArtigos());

            Revista novaRevista = revistaRepository.save(revista);

            RevistaOutputDTO revistaOutputDTO = new RevistaOutputDTO(novaRevista);

            return revistaOutputDTO;
        }catch (Exception e){
            return null;
        }
    }

    public RevistaOutputDTO update(Long id, RevistaInputDTO revistaInputDTO){
        Optional<Revista> possivelRevista = revistaRepository.findById(id);

        if(possivelRevista.isPresent()){
            Revista revistaEncontrada = possivelRevista.get();

            revistaEncontrada.setNome(revistaInputDTO.getNome());
            revistaEncontrada.setISSN(revistaInputDTO.getISSN());
            revistaEncontrada.setArtigos(revistaEncontrada.getArtigos());

            Revista revistaAtualizada = revistaRepository.save(revistaEncontrada);

            return new RevistaOutputDTO(revistaAtualizada);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Revista não encontrada");
        }
    }

    public void delete(Long id){
        if(revistaRepository.existsById(id)){
            revistaRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Revista não encontrada");
        }
    }
}
