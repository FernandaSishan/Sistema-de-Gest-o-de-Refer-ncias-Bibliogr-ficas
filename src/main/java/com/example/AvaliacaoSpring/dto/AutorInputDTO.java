package com.example.AvaliacaoSpring.dto;


public class AutorInputDTO {

    private String nome;
    private String afiliacao;

    //construtor padrão
    public AutorInputDTO(){
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

}
