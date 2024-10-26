package com.example.AvaliacaoSpring.repository;

import com.example.AvaliacaoSpring.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {

    @Query("select e from revista e where e.nome = :nome")
    Revista findByNome(@Param("nome")String nome);
}
