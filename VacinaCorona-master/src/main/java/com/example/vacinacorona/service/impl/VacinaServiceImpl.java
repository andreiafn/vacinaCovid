package com.example.vacinacorona.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vacinacorona.domain.fasesVacina.FasesVacinaRepository;
import com.example.vacinacorona.domain.vacina.Vacina;
import com.example.vacinacorona.domain.vacina.VacinaRepository;
import com.example.vacinacorona.service.VacinaService;

@Service
public class VacinaServiceImpl implements VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private FasesVacinaRepository fasesVacinaRepository;

    @Override
    public Vacina inserir(Vacina vacina){
        Integer maxIdFases = fasesVacinaRepository.selectMaxId();
        Integer maxIdVac = vacinaRepository.selectMaxId();

        if (maxIdFases == null) {
            vacina.getFasesVacina().setId(1L);
        } else {
            vacina.getFasesVacina().setId((long) (maxIdFases + 1));
        }

        if (maxIdVac == null) {
            vacina.setId(1L);
        } else {
            vacina.setId((long) (maxIdVac + 1));
        }

        return this.vacinaRepository.save(vacina);
    }

    @Override
    public List<Vacina> consultar() throws Exception {
        return vacinaRepository.findAll();
    }

    @Override
    public Optional<Vacina> consultarPorId(Long id) throws Exception {
        return this.vacinaRepository.findById(id);
    }

    @Override
    public void deletarVacina(Long id) throws Exception {
        this.vacinaRepository.deleteById(id);
    }

    @Override
    public Vacina atualizarVacina(Vacina vacina) throws Exception {
        return this.vacinaRepository.save(vacina);
    }
}
