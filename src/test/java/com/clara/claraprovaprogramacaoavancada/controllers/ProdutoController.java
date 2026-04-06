package com.clara.claraprovaprogramacaoavancada.controllers;

import com.clara.claraprovaprogramacaoavancada.models.ProdutoModel;
import com.clara.claraprovaprogramacaoavancada.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServices produtoServices;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> produtoLista = produtoServices.findAll();
        return ResponseEntity.ok().body(produtoLista);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> postMappping (@RequestBody ProdutoModel produtoModel) {
        ProdutoModel produto = produtoServices.criar(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(produtoModel.getId()).toUri();
        return ResponseEntity.ok().body(uri);
    }

    @GetMapping
    public Optional<List<ProdutoModel>> findById(Long id){
        ProdutoModel produto = produtoServices.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMapping (Long id){
        produtoServices.deletar(id);
    }
}
