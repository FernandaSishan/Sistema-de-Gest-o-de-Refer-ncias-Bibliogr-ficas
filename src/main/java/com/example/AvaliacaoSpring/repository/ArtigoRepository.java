package com.example.AvaliacaoSpring.repository;

import com.example.AvaliacaoSpring.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

    @Query("select e from artigo e where e.titulo = :titulo")
    Artigo findByNome(@Param("titulo")String titulo);
}
