package com.example.AvaliacaoSpring.repository;

import com.example.AvaliacaoSpring.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("select e from autor e where e.nome = :nome")
    Autor findByNome(@Param("nome")String nome);

}
