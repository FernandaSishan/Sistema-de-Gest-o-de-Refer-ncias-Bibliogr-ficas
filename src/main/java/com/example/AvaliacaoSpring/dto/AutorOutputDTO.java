package com.example.AvaliacaoSpring.dto;

import com.example.AvaliacaoSpring.model.Autor;


public class AutorOutputDTO {

    private long id;
    private String nome;
    private String afiliacao;

    //construtor padrão
    public AutorOutputDTO(){
    }

    public AutorOutputDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.afiliacao = autor.getAfiliacao().getNome();
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

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }
}
