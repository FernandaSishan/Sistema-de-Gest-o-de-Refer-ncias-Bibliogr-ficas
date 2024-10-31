package com.example.AvaliacaoSpring.controller;

import com.example.AvaliacaoSpring.dto.AfiliacaoInputDTO;
import com.example.AvaliacaoSpring.dto.AfiliacaoOutputDTO;
import com.example.AvaliacaoSpring.service.AfiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/afiliacao")
public class AfiliacaoController {

    @Autowired
    private AfiliacaoService afiliacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<AfiliacaoOutputDTO> read (@PathVariable Long id){
        AfiliacaoOutputDTO afiliacao = afiliacaoService.findById(id);

        return ResponseEntity.ok(afiliacao);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AfiliacaoOutputDTO>> list(){

        List<AfiliacaoOutputDTO> afiliacoesOutputDTO = afiliacaoService.list();

        if(!afiliacoesOutputDTO.isEmpty()) {
            return new ResponseEntity<>(afiliacoesOutputDTO, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AfiliacaoOutputDTO> create (@RequestBody AfiliacaoInputDTO afiliacaoInputDTO){

        AfiliacaoOutputDTO afiliacaoOutputDTO = afiliacaoService.create(afiliacaoInputDTO);

        if(afiliacaoOutputDTO != null){
            return new ResponseEntity<>(afiliacaoOutputDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
