package com.example.vacinacorona.service;

import com.example.vacinacorona.domain.pesquisador.Pesquisador;

import java.util.List;
import java.util.Optional;

public interface PesquisadorService {
    List<Pesquisador> buscarTodos() throws Exception;
    Optional<Pesquisador> buscarPeloId(Long codigo) throws Exception;
    Pesquisador incluir(Pesquisador pesquisador) throws Exception;
    Optional<Pesquisador> alterar(Pesquisador pesquisador) throws Exception;
    void excluir(Long id) throws Exception;
}
