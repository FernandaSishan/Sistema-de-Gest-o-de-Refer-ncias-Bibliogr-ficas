package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Autor;

import java.util.HashSet;
import java.util.Set;

public class AutorOutputDetalhadoDTO {

    private long id;
    private String nome;
    private String afiliacao;
    private Set<ArtigoOutputDTO> artigos = new HashSet<>();

    //construtor padrão
    public AutorOutputDetalhadoDTO(){
    }

    public AutorOutputDetalhadoDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.afiliacao = autor.getAfiliacao();
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

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public Set<ArtigoOutputDTO> getArtigos() {
        return artigos;
    }

    public void setArtigos(Set<ArtigoOutputDTO> artigos) {
        this.artigos = artigos;
    }

}
