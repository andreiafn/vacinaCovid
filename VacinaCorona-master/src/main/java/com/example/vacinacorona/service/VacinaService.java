package com.example.vacinacorona.service;

import com.example.vacinacorona.domain.vacina.Vacina;

import java.util.List;
import java.util.Optional;

public interface VacinaService {
    Vacina inserir(Vacina vacina) throws Exception;
    List<Vacina> consultar() throws Exception;
    Optional<Vacina> consultarPorId(Long id) throws Exception;
    void deletarVacina(Long id) throws Exception;
    Vacina atualizarVacina(Vacina vacina) throws Exception;
}
