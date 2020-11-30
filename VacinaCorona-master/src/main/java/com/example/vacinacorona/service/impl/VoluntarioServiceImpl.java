package com.example.vacinacorona.service.impl;

import com.example.vacinacorona.domain.voluntario.Voluntario;
import com.example.vacinacorona.domain.voluntario.VoluntarioRepository;
import com.example.vacinacorona.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Override
    public List<Voluntario> buscarTodos() throws Exception {
        return voluntarioRepository.findAll();
    }

    @Override
    public Optional<Voluntario> buscarPeloId(Long codigo) throws Exception {
        return voluntarioRepository.findById(codigo);
    }

    @Override
    public Voluntario incluir(Voluntario voluntario){
        return voluntarioRepository.save(voluntario);
    }

    @Override
    public void excluir(Long id){
        voluntarioRepository.deleteById(id);
    }

    @Override
    public Optional<Voluntario> alterar(Voluntario voluntario) throws Exception {
        Optional<Voluntario> pesquisadorEntity = buscarPessoaPeloCodigo(voluntario, voluntario.getIdVoluntario());
        return pesquisadorEntity;
    }

    private Optional<Voluntario> buscarPessoaPeloCodigo(Voluntario voluntario, Long codigo) {
        return voluntarioRepository.findById(codigo).map(p -> {
            p.setNome(voluntario.getNome());
            p.setIdade(voluntario.getIdade());
            p.setComorbidades(voluntario.getComorbidades());
            p.setPaisTeste(voluntario.getPaisTeste());
            return voluntarioRepository.save(p);
        });
    }
}
