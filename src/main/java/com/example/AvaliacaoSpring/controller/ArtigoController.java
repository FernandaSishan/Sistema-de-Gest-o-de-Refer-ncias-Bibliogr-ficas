package com.example.AvaliacaoSpring.controller;

import com.example.AvaliacaoSpring.dto.ArtigoInputDTO;
import com.example.AvaliacaoSpring.dto.ArtigoOutputDTO;
import com.example.AvaliacaoSpring.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/artigo")
public class ArtigoController {


    @Autowired
    private ArtigoService artigoService;


    @GetMapping("/{id}")
    public ResponseEntity<ArtigoOutputDTO> read(@PathVariable Long id) {
        ArtigoOutputDTO artigo = artigoService.findById(id);
        return ResponseEntity.ok(artigo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtigoOutputDTO>> list(){

        List<ArtigoOutputDTO> artigosOutputDTO = artigoService.list();


        if (!artigosOutputDTO.isEmpty()) {
            return new ResponseEntity<>(artigosOutputDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ArtigoOutputDTO> create (@RequestBody ArtigoInputDTO artigoInputDTO){

        ArtigoOutputDTO artigoOutputDTO = artigoService.create(artigoInputDTO);

        if(artigoInputDTO != null){
            return new ResponseEntity<>(artigoOutputDTO, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtigoOutputDTO> update(@PathVariable Long id, @RequestBody ArtigoInputDTO artigoInputDTO) {
        ArtigoOutputDTO artigoAtualizado = artigoService.update(id, artigoInputDTO);
        return ResponseEntity.ok(artigoAtualizado);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        artigoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
