package com.example.vacinacorona.resource;

import com.example.vacinacorona.domain.empresa.Empresa;
import com.example.vacinacorona.domain.empresa.EmpresaRepository;
import com.example.vacinacorona.domain.governo.Governo;
import com.example.vacinacorona.domain.governo.GovernoRepository;
import com.example.vacinacorona.domain.paisTeste.PaisTeste;
import com.example.vacinacorona.domain.paisTeste.PaisTesteRepository;
import com.example.vacinacorona.domain.vacina.Vacina;
import com.example.vacinacorona.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping({"/vacina"})
public class VacinaControllerRest {

    @Autowired
    private VacinaService vacinaService;

    @Autowired
    private GovernoRepository governoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PaisTesteRepository paisTesteRepository;

    @PostMapping
    public ResponseEntity<Vacina> inserir(@RequestBody Vacina vacina) throws Exception {
        Vacina vacinaResponse = vacinaService.inserir(vacina);
        return ResponseEntity.status(HttpStatus.OK).body(vacinaResponse);
    }

    @GetMapping
    public ResponseEntity<List<Vacina>> consultarTodos() throws Exception{
        List<Vacina> vacina = vacinaService.consultar();
        return ResponseEntity.status(HttpStatus.OK).body(vacina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vacina>> consultarVacinaId(@PathVariable Long id) throws Exception{
        Optional<Vacina> vacina = this.vacinaService.consultarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(vacina);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirVacina(@PathVariable Long id) throws Exception{
        this.vacinaService.deletarVacina(id);
    }

    @PutMapping
    public ResponseEntity<Vacina> atualizarVacina(@RequestBody Vacina vacina) throws Exception{
        Vacina vacinaResponse = this.vacinaService.atualizarVacina(vacina);
        return ResponseEntity.status(HttpStatus.OK).body(vacinaResponse);
    }

    @GetMapping("/governos")
    public ResponseEntity<List<Governo>> buscarGovernos() throws Exception{
        List<Governo> governos = this.governoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(governos);
    }

    @GetMapping("/empresas")
    public ResponseEntity<List<Empresa>> buscarEmpresas() throws Exception{
        List<Empresa> empresas = this.empresaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(empresas);
    }

    @GetMapping("/paises-teste")
    public ResponseEntity<List<PaisTeste>> buscarPaisesTeste() throws Exception{
        List<PaisTeste> paisTestes = this.paisTesteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(paisTestes);
    }
}
