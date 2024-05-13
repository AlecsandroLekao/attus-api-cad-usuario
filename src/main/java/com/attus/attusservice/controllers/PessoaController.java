package com.attus.attusservice.controllers;

import com.attus.attusservice.models.Pessoa;
import com.attus.attusservice.services.PessoaException;
import com.attus.attusservice.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    Page<Pessoa> getall(Pageable pageable){
        return pessoaService.getAllPessoa(pageable);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Pessoa> getById(@PathVariable(value = "id") String id){
        return ResponseEntity.ok(pessoaService.getById(id));
    }

    @PostMapping
    ResponseEntity<Pessoa> savePessoa(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.savePessoa(pessoa));
    }

    @PatchMapping
    ResponseEntity<Pessoa> atualizaParcial(@Valid @RequestBody Pessoa pessoa, String id){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.updatePessoa(id, pessoa));
    }


}
