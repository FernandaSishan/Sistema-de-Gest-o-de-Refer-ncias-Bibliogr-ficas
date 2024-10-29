package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Artigo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArtigoOutputDTO {

    private Long id;
    private String titulo;
    private String ano;
    private String revista;
    private Set<AutorOutputDTO> autores = new HashSet<>();

    public Set<AutorOutputDTO> getAutores() {
        return autores;
    }

    public void setAutores(Set<AutorOutputDTO> autores) {
        this.autores = autores;
    }

    public ArtigoOutputDTO(){
    }

    //Construtores
    public ArtigoOutputDTO(Artigo artigo) {
        this.id = artigo.getId();
        this.titulo = artigo.getTitulo();
        this.ano = artigo.getAno();
        this.revista = artigo.getRevista().getNome();
        this.autores = artigo.getAutores().stream().map(AutorOutputDTO::new).collect(Collectors.toSet());
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

}
