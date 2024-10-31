package com.example.AvaliacaoSpring.repository;


import com.example.AvaliacaoSpring.model.Afiliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacaoRepository extends JpaRepository<Afiliacao, Long> {

    @Query("select e from afiliacao e where e.nome = :nome")
    Afiliacao findByNome(@Param("nome")String nome);
}
