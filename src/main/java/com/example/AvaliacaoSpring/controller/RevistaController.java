package com.example.AvaliacaoSpring.controller;


import com.example.AvaliacaoSpring.dto.RevistaInputDTO;
import com.example.AvaliacaoSpring.dto.RevistaOutputDTO;
import com.example.AvaliacaoSpring.dto.RevistaOutputDetalhadoDTO;
import com.example.AvaliacaoSpring.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/revista")
public class RevistaController {

    @Autowired
    private RevistaService revistaService;

    @GetMapping("/{id}")
    public ResponseEntity<RevistaOutputDetalhadoDTO> read (@PathVariable Long id){
        RevistaOutputDetalhadoDTO revista = revistaService.findById(id);
        return ResponseEntity.ok(revista);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RevistaOutputDTO>> list(){

        List<RevistaOutputDTO> revistasOutputDTO = revistaService.list();

        if(!revistasOutputDTO.isEmpty()){
            return new ResponseEntity<>(revistasOutputDTO, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RevistaOutputDTO> create (@RequestBody RevistaInputDTO revistaInputDTO){

        RevistaOutputDTO revistaOutputDTO = revistaService.create(revistaInputDTO);

        if (revistaOutputDTO != null){
            return new ResponseEntity<>(revistaOutputDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RevistaOutputDTO> update(@PathVariable Long id, @RequestBody RevistaInputDTO revistaInputDTO){

        RevistaOutputDTO revistaAtualizada = revistaService.update(id, revistaInputDTO);
        return ResponseEntity.ok(revistaAtualizada);
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        revistaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
