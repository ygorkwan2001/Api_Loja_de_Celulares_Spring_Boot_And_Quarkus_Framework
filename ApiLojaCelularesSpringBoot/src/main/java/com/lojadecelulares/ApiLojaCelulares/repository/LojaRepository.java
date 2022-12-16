package com.lojadecelulares.ApiLojaCelulares.repository;


import com.lojadecelulares.ApiLojaCelulares.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
}
