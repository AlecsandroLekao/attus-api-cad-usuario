package com.attus.attusservice.services;

import com.attus.attusservice.models.Pessoa;
import com.attus.attusservice.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class PessoaServiceIMPL implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public Page<Pessoa> getAllPessoa(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Pessoa getById(String id) {
        return getbyId(id);
    }

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {

        if (pessoa.getEndereco().stream().allMatch(value -> value.getPrincipal().equals(true))){
            throw new PessoaException("Dois enderecos principais");
        }
        return repository.save(pessoa);
    }

    @Override
    public Pessoa updatePessoa(String id, Pessoa pessoa) {
        Pessoa p = getbyId(id);

        if(!isNull(pessoa.getNomeCompleto()) ){
            p.setNomeCompleto(pessoa.getNomeCompleto());
        }
        if(!isNull(pessoa.getEndereco()) ){
            p.setEndereco(pessoa.getEndereco());
        }
        if(!isNull(pessoa.getDataNascimento()) ){
            p.setDataNascimento(pessoa.getDataNascimento());
        }
        return repository.save(p);
    }

    private Pessoa getbyId(String id){
        return repository.findById(id).orElseThrow(() -> new PessoaException("Id nao localizado"));
    }
}
