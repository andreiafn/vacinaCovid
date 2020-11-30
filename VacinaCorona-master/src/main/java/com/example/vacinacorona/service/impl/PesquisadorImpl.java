package com.example.vacinacorona.service.impl;

import com.example.vacinacorona.domain.pesquisador.Pesquisador;
import com.example.vacinacorona.domain.pesquisador.PesquisadorRepository;
import com.example.vacinacorona.service.PesquisadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesquisadorImpl implements PesquisadorService {

    @Autowired
    private PesquisadorRepository pesquisadorRepository;

    @Override
    public List<Pesquisador> buscarTodos() throws Exception {
        return pesquisadorRepository.findAll();
    }

    @Override
    public Optional<Pesquisador> buscarPeloId(Long codigo) throws Exception {
        return pesquisadorRepository.findById(codigo);
    }

    @Override
    public Pesquisador incluir(Pesquisador pesquisador) throws Exception {
        Integer maxId = pesquisadorRepository.selectMaxId();

        if (maxId == null) {
            pesquisador.setId(1L);
        } else {
            pesquisador.setId((long) (maxId + 1));
        }

        return pesquisadorRepository.save(pesquisador);
    }

    @Override
    public void excluir(Long id) throws Exception {
        pesquisadorRepository.deleteById(id);
    }

    @Override
    public Optional<Pesquisador> alterar(Pesquisador pesquisador) throws Exception {
        Optional<Pesquisador> pesquisadorEntity = buscarPessoaPeloCodigo(pesquisador, pesquisador.getId());
        return pesquisadorEntity;
    }

    private Optional<Pesquisador> buscarPessoaPeloCodigo(Pesquisador pesquisador, Long codigo) {
        return pesquisadorRepository.findById(codigo).map(p -> {
            p.setNome(pesquisador.getNome());
            p.setIdade(pesquisador.getIdade());
            p.setCargo(pesquisador.getCargo());
            p.setEmail(pesquisador.getEmail());
            p.setVacina(pesquisador.getVacina());
            return pesquisadorRepository.save(p);
        });
    }
}
