package com.attus.attusservice.services;

import com.attus.attusservice.models.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PessoaService {

    Page<Pessoa> getAllPessoa(Pageable pageable);
    Pessoa getById(String id);
    Pessoa savePessoa(Pessoa pessoa);
    Pessoa updatePessoa(String id, Pessoa pessoa);

}
