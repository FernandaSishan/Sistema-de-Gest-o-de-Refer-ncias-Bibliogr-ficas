package com.example.AvaliacaoSpring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "revista")
public class Revista {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = true)
    private String nome;
    @Column(nullable = true, unique = true)
    private String ISSN;
    @OneToMany(mappedBy = "revista")
    private List<Artigo> artigos = new ArrayList<Artigo>();

    //construtor padrão
    public Revista(){
    }

    //Construtores

    public Revista(long id, String nome, String ISSN, List<Artigo> artigos) {
        this.id = id;
        this.nome = nome;
        this.ISSN = ISSN;
        this.artigos = artigos;
    }

    //Get and setters


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

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }
}
