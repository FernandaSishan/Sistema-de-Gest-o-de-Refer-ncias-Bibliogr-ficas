package com.example.AvaliacaoSpring.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Autor> autores = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "revista_id")
    private Revista revista;


    //contrutor padrão
    public Artigo(){
    }

    //Construtores

    public Artigo(long id, String titulo, String ano, Set<Autor> autores, Revista revista) {
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

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }
}
