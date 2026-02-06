package com.wdev.springboot.controllers;

import com.wdev.springboot.dtos.ProdutosRecordDto;
import com.wdev.springboot.models.ProdutoModel;
import com.wdev.springboot.repositories.ProdutoRepositories;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepositories produtoRepositories;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody @Valid ProdutosRecordDto produtosRecordDto){
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtosRecordDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepositories.save(produtoModel));
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModel>> pegarProdutosPorMarca(@RequestParam(name = "marca", required = false) String filtroMarca){

        List<ProdutoModel> produtos;
        // validação
        if(filtroMarca != null && !filtroMarca.isBlank()){
            produtos = produtoRepositories.findByMarca(filtroMarca);
        }else {
            produtos = produtoRepositories.findAll();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }




}
