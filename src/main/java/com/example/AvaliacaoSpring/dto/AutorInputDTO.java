package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Artigo;

import java.util.Set;

public class AutorInputDTO {

    private String nome;
    private String afiliacao;
    private Set<Artigo> artigos;

    //construtor padrão
    public AutorInputDTO(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public Set<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(Set<Artigo> artigos) {
        this.artigos = artigos;
    }
}
