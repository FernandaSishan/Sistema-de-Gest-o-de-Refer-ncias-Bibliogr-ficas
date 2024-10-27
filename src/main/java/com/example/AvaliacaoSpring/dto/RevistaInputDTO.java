package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Artigo;

import java.util.List;

public class RevistaInputDTO {

    private String nome;
    private String ISSN;
    private List<Artigo> artigos;

    //construtor padrão
    public RevistaInputDTO(){
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

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

}
