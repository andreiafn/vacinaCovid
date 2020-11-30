package com.example.vacinacorona.resource;

import com.example.vacinacorona.domain.voluntario.Voluntario;
import com.example.vacinacorona.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping({"/voluntario"})
public class VoluntarioControllerRest {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping
    public ResponseEntity<List<Voluntario>> buscarTodos() throws Exception {
        List<Voluntario> voluntarios = voluntarioService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(voluntarios);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Voluntario>> buscarPeloId(@PathVariable Long codigo) throws Exception{
        Optional<Voluntario> pesquisador = voluntarioService.buscarPeloId(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(pesquisador);
    }

    @PostMapping
    public ResponseEntity<Voluntario> inserir(@RequestBody Voluntario voluntario) throws Exception{
        Voluntario pesquisadorResponse = voluntarioService.incluir(voluntario);
        return ResponseEntity.status(HttpStatus.OK).body(pesquisadorResponse);
    }

    @PutMapping
    public Optional<Voluntario> alterar(@RequestBody Voluntario voluntario) throws Exception{
        return voluntarioService.alterar(voluntario);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo) throws Exception{
        voluntarioService.excluir(codigo);
        ResponseEntity.ok();
    }


}
