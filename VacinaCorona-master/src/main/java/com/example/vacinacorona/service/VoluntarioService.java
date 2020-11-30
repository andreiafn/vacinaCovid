package com.example.vacinacorona.service;

import com.example.vacinacorona.domain.voluntario.Voluntario;

import java.util.List;
import java.util.Optional;

public interface VoluntarioService {
    List<Voluntario> buscarTodos() throws Exception;
    Optional<Voluntario> buscarPeloId(Long codigo) throws Exception;
    Voluntario incluir(Voluntario voluntario) throws Exception;
    void excluir(Long id) throws Exception;
    Optional<Voluntario> alterar(Voluntario voluntario) throws Exception;
}
