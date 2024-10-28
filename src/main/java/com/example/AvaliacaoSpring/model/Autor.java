package com.example.AvaliacaoSpring.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "autor")
public class Autor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(nullable = true, unique = false)
    private String nome;
    @Column(nullable = true, unique = false)
    private String afiliacao;

    // criar uma tabela de relacionamento para autor/artigo

    @ManyToMany
    @JoinTable(
            name = "autor_artigo",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "artigo_id")
    )

    private Set<Artigo> artigos = new HashSet<>();

    // Construtor padrão
    public Autor() {
    }

    //Construtores

    public Autor(long id, String nome, String afiliacao, Set<Artigo> artigos) {
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

    public Set<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(Set<Artigo> artigos) {
        this.artigos = artigos;
    }
}