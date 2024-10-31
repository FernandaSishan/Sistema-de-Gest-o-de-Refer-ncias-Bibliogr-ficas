package com.example.AvaliacaoSpring.dto;


import com.example.AvaliacaoSpring.model.Autor;
import com.example.AvaliacaoSpring.repository.AfiliacaoRepository;

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

    public Autor build(AfiliacaoRepository afiliacaoRepository){
        Autor autor = new Autor();
        autor.setNome((this.nome));
        autor.setAfiliacao(afiliacaoRepository.findByNome(this.afiliacao));
        return autor;
    }
}
