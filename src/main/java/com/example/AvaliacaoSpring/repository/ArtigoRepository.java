package com.example.AvaliacaoSpring.repository;

import com.example.AvaliacaoSpring.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> {

}
