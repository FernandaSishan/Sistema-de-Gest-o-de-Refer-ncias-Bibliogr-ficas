package com.example.AvaliacaoSpring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "autor")
public class Autor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = true, unique = false)
    private String nome;
    @Column(nullable = true, unique = false)
    private String afiliacao;

    // criar uma tabela intermediária para autor/artigo
    @ManyToMany
    @JoinTable(
            name = "autor_artigo",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "artigo_id")
    )

    private List<Artigo> artigos = new ArrayList<Artigo>();

    public Autor() {
    }

    //Construtores

    public Autor(long id, String nome, String afiliacao, List<Artigo> artigos) {
        this.id = id;
        this.nome = nome;
        this.afiliacao = afiliacao;
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

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }
}