package com.example.AvaliacaoSpring.controller;

import com.example.AvaliacaoSpring.dto.AutorInputDTO;
import com.example.AvaliacaoSpring.dto.AutorOutputDTO;
import com.example.AvaliacaoSpring.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/{id}")
    public ResponseEntity<AutorOutputDTO> read(@PathVariable Long id) {
        AutorOutputDTO autor = autorService.findById(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AutorOutputDTO>> list(){

        List<AutorOutputDTO> autoresOutputDTO = autorService.list();

        if (!autoresOutputDTO.isEmpty()) {
            return new ResponseEntity<>(autoresOutputDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorOutputDTO> create(@RequestBody AutorInputDTO autorInputDTO){

        AutorOutputDTO autorOutputDTO = autorService.create(autorInputDTO);

            if(autorOutputDTO != null){
                return new ResponseEntity<>(autorOutputDTO, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutorOutputDTO> update(@PathVariable Long id, @RequestBody AutorInputDTO autorInputDTO){

        AutorOutputDTO autorAtualizado = autorService.update(id, autorInputDTO);
        return ResponseEntity.ok(autorAtualizado);

    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
