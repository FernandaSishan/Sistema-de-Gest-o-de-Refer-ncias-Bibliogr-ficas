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
    private int ISSN;
    @OneToMany(mappedBy = "revista")
    private List<Artigo> artigos = new ArrayList<Artigo>();

    public Revista(){
    }

    //Construtores

    public Revista(long id, String nome, int ISSN) {
        this.id = id;
        this.nome = nome;
        this.ISSN = ISSN;
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

    public void setName(String nome) {
        this.nome = nome;
    }

    public int getISSN() {
        return ISSN;
    }

    public void setISSN(int ISSN) {
        this.ISSN = ISSN;
    }
}
