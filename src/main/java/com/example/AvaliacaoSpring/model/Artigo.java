package com.example.AvaliacaoSpring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "artigo")
public class Artigo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = true, unique = true)
    private String titulo;
    @Column(nullable = true)
    private String ano;

    @ManyToMany(mappedBy = "artigos")
    private List<Autor> autores = new ArrayList<Autor>();

    @ManyToOne
    @JoinColumn(name = "revista_id")
    private Revista revista;

    public Artigo(){
    }

    //Construtores

    public Artigo(long id, String titulo, String ano, List<Autor> autores, Revista revista) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.autores = autores;
        this.revista = revista;
    }

    //Get and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }
}
