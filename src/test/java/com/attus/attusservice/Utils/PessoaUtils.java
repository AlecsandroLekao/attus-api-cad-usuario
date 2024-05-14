package com.attus.attusservice.Utils;

import com.attus.attusservice.models.Endereco;
import com.attus.attusservice.models.Pessoa;

import java.time.LocalDate;
import java.util.List;

public class PessoaUtils {

    public static final String NOME_COMPLETO = "nome-completo";

    public static Pessoa criaPessoa(){
        Pessoa p = new Pessoa();
        p.setNomeCompleto(NOME_COMPLETO);
        p.setDataNascimento(LocalDate.now());
        p.setId("id");

        Endereco endereco = new Endereco();
        endereco.setCep("cep");
        endereco.setCidade("cidade");
        endereco.setLogradouro("logradouro");
        endereco.setNumero("numero");
        endereco.setPrincipal(Boolean.TRUE);

        Endereco endereco2 = new Endereco();
        endereco2.setCep("cep");
        endereco2.setCidade("cidade");
        endereco2.setLogradouro("logradouro");
        endereco2.setNumero("numero");
        endereco2.setPrincipal(Boolean.FALSE);

        p.setEndereco(List.of(endereco,endereco2));
        return  p;
    }

}
