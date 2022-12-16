package com.lojadecelulares.ApiLojaCelulares.controller;


import com.lojadecelulares.ApiLojaCelulares.dto.ProdutoDto;
import com.lojadecelulares.ApiLojaCelulares.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/loja/{idLoja}")
    public ResponseEntity<List<ProdutoDto>> buscaProdutosPorLoja(@PathVariable long idLoja){
        return new ResponseEntity<List<ProdutoDto>>(produtoService.produtosPorLoja(idLoja), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criaNovoProduto(@RequestBody ProdutoDto produto){
        try {
            produtoService.adicionarProduto(produto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editaProduto(@RequestBody ProdutoDto produto, @PathVariable long id){
        try {
            produtoService.editarProduto(produto, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeProduto(@PathVariable long id){
        try {
            produtoService.deletarProduto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
