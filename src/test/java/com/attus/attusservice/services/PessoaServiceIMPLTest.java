package com.attus.attusservice.services;

import com.attus.attusservice.models.Pessoa;
import com.attus.attusservice.repositories.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.attus.attusservice.Utils.PessoaUtils.NOME_COMPLETO;
import static com.attus.attusservice.Utils.PessoaUtils.criaPessoa;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceIMPLTest {

    public static final String ID = "id";
    @Mock
    private PessoaRepository repository;

    @InjectMocks
    private PessoaServiceIMPL pessoaService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateGetAllPessoas() {

        Page<Pessoa> pagedResponse = new PageImpl(List.of(criaPessoa()));
        when(repository.findAll(any(Pageable.class)))
                .thenReturn(pagedResponse);
        var pessoaMock =  pessoaService.getAllPessoa(PageRequest.of(0, 10));
        assertNotNull(pessoaMock);
        verify(repository,times(1)).findAll(any(Pageable.class));
    }

    @Test
    void validategetById() {
        when(repository.findById(ID)).thenReturn(Optional.of(criaPessoa()));
        var pessoaMock = pessoaService.getById(ID);
        assertNotNull(pessoaMock);
        assertEquals(NOME_COMPLETO,pessoaMock.getNomeCompleto());
        verify(repository,times(1)).findById(ID);
    }

    @Test
    void validateSavePessoa() {
        Pessoa p = criaPessoa();
        when(repository.save(p)).thenReturn(p);
        var pessoaMock = pessoaService.savePessoa(p);
        assertNotNull(pessoaMock);
        verify(repository,times(1)).save(any());
    }

    @Test
    void validateSavePessoaWithTwoPrincipalAdressExpectError() {
        Pessoa p = criaPessoa();
        p.getEndereco().forEach(value -> value.setPrincipal(Boolean.TRUE));

      assertThrows(PessoaException.class,
              () -> pessoaService.savePessoa(p));

        verify(repository,times(0)).save(any());
    }

    @Test
    void updatePessoa() {
        Pessoa p = criaPessoa();
        when(repository.save(p)).thenReturn(p);
        when(repository.findById(ID)).thenReturn(Optional.of(p));
        var pessoaMock = pessoaService.updatePessoa(ID, p);
        assertNotNull(pessoaMock);
        verify(repository,times(1)).save(any());
        verify(repository,times(1)).findById(ID);
    }
}