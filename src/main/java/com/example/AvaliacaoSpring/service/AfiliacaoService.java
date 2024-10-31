package com.example.AvaliacaoSpring.service;

import com.example.AvaliacaoSpring.dto.AfiliacaoInputDTO;
import com.example.AvaliacaoSpring.dto.AfiliacaoOutputDTO;
import com.example.AvaliacaoSpring.model.Afiliacao;
import com.example.AvaliacaoSpring.repository.AfiliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AfiliacaoService {

    @Autowired
    private AfiliacaoRepository afiliacaoRepository;

    public AfiliacaoOutputDTO findById(Long id){
        Optional<Afiliacao> afiliacao = afiliacaoRepository.findById(id);
        if(afiliacao.isPresent()){
            return new AfiliacaoOutputDTO(afiliacao.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Afiliação não encontrada");
        }
    }

    public List<AfiliacaoOutputDTO> list(){

        List<Afiliacao> afiliacoes = afiliacaoRepository.findAll();
        List<AfiliacaoOutputDTO> afiliacoesOutputDTO = new ArrayList<>();

        for(Afiliacao afiliacao: afiliacoes){
            afiliacoesOutputDTO.add(new AfiliacaoOutputDTO(afiliacao));
        }

        return afiliacoesOutputDTO;
    }

    public AfiliacaoOutputDTO create(AfiliacaoInputDTO afiliacaoInputDTO){

        try{
            Afiliacao afiliacao = new Afiliacao();
            afiliacao.setNome(afiliacaoInputDTO.getNome());
            afiliacao.setSigla(afiliacaoInputDTO.getSigla());
            afiliacao.setReferencia(afiliacaoInputDTO.getReferencia());

            Afiliacao novaAfiliacao = afiliacaoRepository.save(afiliacao);

            AfiliacaoOutputDTO afiliacaoOutputDTO = new AfiliacaoOutputDTO(novaAfiliacao);

            return afiliacaoOutputDTO;
        }catch (Exception e){
            return null;
        }
    }

}
