package com.example.vacinacorona.resource;

import com.example.vacinacorona.domain.pesquisador.Pesquisador;
import com.example.vacinacorona.service.PesquisadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping({"/pesquisador"})
public class PesquisadorControllerRest {

    @Autowired
    private PesquisadorService pesquisadorService;

    @GetMapping
    public ResponseEntity<List<Pesquisador>> buscarTodos() throws Exception{
        List<Pesquisador> pesquisadores = pesquisadorService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pesquisadores);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Pesquisador>> buscarPeloId(@PathVariable Long codigo) throws Exception{
        Optional<Pesquisador> pesquisador = pesquisadorService.buscarPeloId(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(pesquisador);
    }

    @PostMapping
    public ResponseEntity<Pesquisador> inserir(@RequestBody Pesquisador pesquisador) throws Exception{
        Pesquisador pesquisadorResponse = pesquisadorService.incluir(pesquisador);
        return ResponseEntity.status(HttpStatus.OK).body(pesquisadorResponse);
    }

    @PutMapping
    public Optional<Pesquisador> alterar(@RequestBody Pesquisador pesquisador) throws Exception{
        return pesquisadorService.alterar(pesquisador);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo) throws Exception{
        pesquisadorService.excluir(codigo);
        ResponseEntity.ok();
    }

}
