package com.example.AvaliacaoSpring.dto;



public class RevistaInputDTO {

    private String nome;
    private String ISSN;

    //construtor padrão
    public RevistaInputDTO(){
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
}
