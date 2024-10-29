package com.example.AvaliacaoSpring.repository;

import com.example.AvaliacaoSpring.dto.AutorInputDTO;
import com.example.AvaliacaoSpring.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("select e from autor e where e.nome = :nome")
    Autor findByNome(@Param("nome")String nome);

    @Query("select e from autor e where e.nome = :nome and e.afiliacao = :afiliacao")
    Autor findAutorEspecifico(@Param("nome") String nome, @Param("afiliacao") String afiliacao);

}
