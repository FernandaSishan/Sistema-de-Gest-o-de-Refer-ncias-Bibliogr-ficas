package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Afiliacao;

public class AfiliacaoOutputDTO {

    private long id;
    private String nome;
    private String sigla;
    private String referencia;

    public AfiliacaoOutputDTO(){
    }

    public AfiliacaoOutputDTO(Afiliacao afiliacao) {
        this.id = afiliacao.getId();
        this.nome = afiliacao.getNome();
        this.sigla = afiliacao.getSigla();
        this.referencia = afiliacao.getReferencia();
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
