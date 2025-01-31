package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Artigo;
import com.example.AvaliacaoSpring.model.Revista;

import java.util.List;

public class RevistaOutputDTO {

    private long id;
    private String nome;
    private String ISSN;

    public RevistaOutputDTO(){
    }

    public RevistaOutputDTO(Revista revista) {
        this.id = revista.getId();
        this.nome = revista.getNome();
        this.ISSN = revista.getISSN();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }
}
