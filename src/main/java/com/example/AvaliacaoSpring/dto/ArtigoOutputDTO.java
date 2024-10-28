package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Artigo;
import com.example.AvaliacaoSpring.model.Autor;

import java.util.List;
import java.util.Set;

public class ArtigoOutputDTO {

    private Long id;
    private String titulo;
    private String ano;
    private String revista;
    private Set<Autor> autores;

    public ArtigoOutputDTO(){
    }

    //Construtores
    public ArtigoOutputDTO(Artigo artigo) {
        this.id = artigo.getId();
        this.titulo = artigo.getTitulo();
        this.ano = artigo.getAno();
        this.revista = artigo.getRevista().getNome();
        this.autores = artigo.getAutores();
    }

    //Get and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getRevista() {
        return revista;
    }

    public void setRevista(String revista) {
        this.revista = revista;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
}
