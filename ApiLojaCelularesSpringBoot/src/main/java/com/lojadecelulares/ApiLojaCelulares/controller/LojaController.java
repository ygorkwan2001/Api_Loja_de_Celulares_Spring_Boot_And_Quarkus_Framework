package com.lojadecelulares.ApiLojaCelulares.controller;

import com.lojadecelulares.ApiLojaCelulares.dto.LojaDto;
import com.lojadecelulares.ApiLojaCelulares.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaService lojaService;


    @GetMapping
    public ResponseEntity<List<LojaDto>> buscaLojas() throws Exception {
        return new ResponseEntity<List<LojaDto>>(lojaService.buscaLojas(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criaNovaLoja(@RequestBody LojaDto loja){
        try {
            lojaService.adicionaLoja(loja);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
