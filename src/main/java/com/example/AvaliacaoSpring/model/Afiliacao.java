package com.example.AvaliacaoSpring.model;


import jakarta.persistence.*;

@Entity(name = "afiliacao")
public class Afiliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true)
    private String nome;
    @Column(nullable = true)
    private String sigla;
    @Column(nullable = true, unique = true)
    private String referencia;

    public Afiliacao(){
    }

    public Afiliacao(long id, String nome, String sigla, String referencia) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.referencia = referencia;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
