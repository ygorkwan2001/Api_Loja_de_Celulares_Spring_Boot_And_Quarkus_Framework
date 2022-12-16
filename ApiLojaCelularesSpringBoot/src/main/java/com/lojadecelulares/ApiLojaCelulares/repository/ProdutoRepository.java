package com.lojadecelulares.ApiLojaCelulares.repository;

import com.lojadecelulares.ApiLojaCelulares.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByLojaId(long idLoja);
}
