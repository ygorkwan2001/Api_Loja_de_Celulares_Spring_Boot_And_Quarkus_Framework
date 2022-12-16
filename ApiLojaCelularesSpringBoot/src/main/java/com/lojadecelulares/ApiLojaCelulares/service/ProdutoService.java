package com.lojadecelulares.ApiLojaCelulares.service;

import com.lojadecelulares.ApiLojaCelulares.dto.ProdutoDto;
import com.lojadecelulares.ApiLojaCelulares.model.Loja;
import com.lojadecelulares.ApiLojaCelulares.model.Produto;
import com.lojadecelulares.ApiLojaCelulares.repository.LojaRepository;
import com.lojadecelulares.ApiLojaCelulares.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public List<ProdutoDto> produtosPorLoja(long idLoja){

        List<Produto> produtosPorLoja = produtoRepository.findByLojaId(idLoja);

        return mapProdutoDto(produtosPorLoja);
    }

    public void adicionarProduto(ProdutoDto produto){

        Loja loja = lojaRepository.findById(produto.getIdLoja()).get();
        produtoRepository.save(new Produto(loja, produto.getMarca(), produto.getModelo(), produto.getDescricao(), produto.getPreco()));

    }

    public void editarProduto(ProdutoDto produto, long id){
        produtoRepository.findById(id).ifPresentOrElse(item->{
            item.setDescricao(produto.getDescricao());
            item.setPreco(produto.getPreco());
            produtoRepository.save(item);
        }, ()-> {
            throw  new NoSuchElementException();
        });
    }

    public void deletarProduto(long id) {
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
    private List<ProdutoDto> mapProdutoDto(List<Produto> produtos){

        List<ProdutoDto> produtosDto = new ArrayList<>();

        produtos.forEach(item->{
            ProdutoDto prods = new ProdutoDto(item.getId(), item.getLoja().getId(), item.getMarca(), item.getModelo(), item.getDescricao(), item.getPreco());
            produtosDto.add(prods);
        });

        return produtosDto;
    }
}
