import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AppComponentService} from "./voluntario/app.component.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Vacina} from "./vacina";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  @ViewChild('alert', { static: true }) alert: ElementRef;

  formularioVacina: FormGroup;
  formularioFases: FormGroup;
  formularioPaises: FormGroup;
  formularioEfeitosColaterais: FormGroup;
  formularioGoverno: FormGroup;
  formularioVoluntario: FormGroup;

  formularioPesquisador: FormGroup;

  formularioEmpresa: FormGroup;
  listaEfeitosAdicionados=[];
  listaPaisesSelecionados=[];
  listaVacinasCombo = [];
  listaPaises = []

  listaVacinasCadastradas = [];

  sucesso: boolean = false;
  escopo: any;
  vacina = {id:null, nomeVacina:null};
  paisSelecionado = {idPaisTeste:null, nome:null, numParticipantes:null}
  listaPesquidores = [];
  listaVoluntarios = [];

  constructor(private service: AppComponentService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.initForms();
    /*this.getGovernos();
    this.getEmpresas();
    this.getPaises();*/
  }

  private initForms() {
    this.formularioVacina = this.formBuilder.group({
      id:null,
      nomeVacina: null,
      estoque: null
    });

    this.formularioFases = this.formBuilder.group({
      id:null,
      fase1: null,
      fase2: null,
      fase3: null,
      fase4: null
    });

    this.formularioPaises = this.formBuilder.group({
      idPaisTeste:null,
      nome: null,
      numParticipantes: null,
    });

    this.formularioEfeitosColaterais = this.formBuilder.group({
      idEfeitosColaterais:null,
      descricao: null,
      tipo: null
    });

    this.formularioGoverno = this.formBuilder.group({
      idGoverno: null,
      nome: null
    });

    this.formularioEmpresa = this.formBuilder.group({
      idEmpresa:null,
      nomeEmpresa: null
    });

    this.formularioPesquisador = this.formBuilder.group({
      id:null,
      nome: null,
      idade: null,
      email: null,
      cargo: null
    });

    this.formularioVoluntario = this.formBuilder.group({
      idVoluntario: null,
      nome: null,
      idade: null,
      comorbidades: null,
    })
  }

  salvarVacina() {
    let obj = this.formularioVacina.getRawValue();

    obj.governo = this.formularioGoverno.getRawValue();
    obj.empresa = this.formularioEmpresa.getRawValue();
    obj.fasesVacina = this.formularioFases.getRawValue();
    obj.paisesTeste = this.listaPaisesSelecionados;
    obj.efeitosColaterais = this.listaEfeitosAdicionados;

    this.service.salvarVacina(obj).subscribe(res=>{
      window.scrollTo(0, 0);
      this.sucesso = true;
      this.formularioEmpresa.reset();
      this.formularioGoverno.reset();
      this.formularioPaises.reset();
      this.formularioEfeitosColaterais.reset();
      this.formularioFases.reset();
      this.formularioVacina.reset();
    });
    console.log(obj)
  }

  adicionarEfeitos() {
    let obj = this.formularioEfeitosColaterais.getRawValue();

    if(obj.tipo == 'C'){
      obj.comum = 'SIM';
      obj.incomum = 'NÃO';
      obj.raro = 'NÃO';
    }else if(obj.tipo == 'I'){
      obj.comum = 'NÃO';
      obj.incomum = 'SIM';
      obj.raro = 'NÃO';
    }else{
      obj.comum = 'NÃO';
      obj.incomum = 'NÃO';
      obj.raro = 'SIM';
    }
    this.listaEfeitosAdicionados.push(obj);
    this.formularioEfeitosColaterais.reset();
  }

  adicionarPaises() {
    let obj = this.formularioPaises.getRawValue();
    this.listaPaisesSelecionados.push(obj);
    this.formularioPaises.reset();
  }

  definirEscopo(cod) {
    this.listaEfeitosAdicionados = [];
    this.listaPaisesSelecionados = [];
    this.formularioVoluntario.reset();
    this.formularioPesquisador.reset();
    this.formularioEmpresa.reset();
    this.formularioVacina.reset();
    this.formularioFases.reset();
    this.formularioEfeitosColaterais.reset();
    this.formularioPaises.reset();
    this.formularioGoverno.reset();
    
    this.escopo = cod;
    if(this.escopo == 4){
      this.service.getVacinas().subscribe(res=>{
        this.listaVacinasCombo = res;
      })
    }
    if(this.escopo == 7){
      this.service.getPaises().subscribe(res=>{
        this.listaPaises = res;
      })
    }
  }

  listarVacinas() {
    this.escopo = 2;
    this.service.getVacinas().subscribe(res=>{
      this.listaVacinasCadastradas = res;
    })
  }

  excluirVacina(idVacina: any) {
    debugger;
    this.service.excluirVacinas(idVacina).subscribe(res=>{
      this.listarVacinas();
    })
  }

  editarVacina(vac: any) {
    this.formularioVacina.get('nomeVacina').setValue(vac.nomeVacina);
    this.formularioVacina.get('estoque').setValue(vac.estoque);
    this.formularioVacina.get('id').setValue(vac.id);

    this.formularioFases.get('fase1').setValue(vac.fasesVacina.fase1);
    this.formularioFases.get('fase2').setValue(vac.fasesVacina.fase2);
    this.formularioFases.get('fase3').setValue(vac.fasesVacina.fase3);
    this.formularioFases.get('fase4').setValue(vac.fasesVacina.fase4);
    this.formularioFases.get('id').setValue(vac.fasesVacina.id);

    this.formularioGoverno.get('idGoverno').setValue(vac.governo.idGoverno);
    this.formularioGoverno.get('nome').setValue(vac.governo.nome);
    this.formularioEmpresa.get('nomeEmpresa').setValue(vac.empresa.nomeEmpresa);

    this.formularioEmpresa.get('idEmpresa').setValue(vac.empresa.idEmpresa);
    this.formularioEmpresa.get('nomeEmpresa').setValue(vac.empresa.nomeEmpresa);

    this.listaPaisesSelecionados = vac.paisesTeste;
    this.listaEfeitosAdicionados = vac.efeitosColaterais;
    debugger;

    this.escopo = 3;
  }


  excluirEfeito(vac: any) {
    let index = this.listaEfeitosAdicionados.indexOf(vac);
    this.listaEfeitosAdicionados.splice(index, 1);
  }

  excluirPais(vac: any) {
    debugger;
    let index = this.listaPaisesSelecionados.indexOf(vac);
    this.listaPaisesSelecionados.splice(index, 1);
  }

  alterarVacina() {
    let obj = this.formularioVacina.getRawValue();

    obj.governo = this.formularioGoverno.getRawValue();
    obj.empresa = this.formularioEmpresa.getRawValue();
    obj.fasesVacina = this.formularioFases.getRawValue();
    obj.paisesTeste = this.listaPaisesSelecionados;
    obj.efeitosColaterais = this.listaEfeitosAdicionados;
    this.service.alterarVacina(obj).subscribe(res=>{
      window.scrollTo(0, 0);
      this.sucesso = true;
      this.formularioEmpresa.reset();
      this.formularioGoverno.reset();
      this.formularioPaises.reset();
      this.formularioEfeitosColaterais.reset();
      this.formularioFases.reset();
      this.formularioVacina.reset();
    })
  }

  closeAlert() {
    this.sucesso = false;
    this.alert.nativeElement.classList.remove('show');
  }

  salvarPesquisador() {
    let obj = this.formularioPesquisador.getRawValue();
    obj.vacina = {id: this.vacina.id, nomeVacina: this.vacina.nomeVacina};
    this.service.salvarPesquisador(obj).subscribe(res=>{
      window.scrollTo(0, 0);
      this.formularioPesquisador.reset();
      this.sucesso = true;
    })
  }

  listarPesquisador(){
    this.escopo = 5;
    this.service.listarPesquisadores().subscribe(res=>{
      this.listaPesquidores = res;
    })
  }

  alterarPesquisador() {
    let obj = this.formularioPesquisador.getRawValue();
    obj.vacina = {id: this.vacina.id, nomeVacina: this.vacina.nomeVacina};
    this.service.alterarPesquisador(obj).subscribe(res=>{
      window.scrollTo(0, 0);
      this.formularioPesquisador.reset();
      this.sucesso = true;
    })
  }

  editarPesquisador(pes: any) {
    this.escopo = 6;

    this.service.getVacinas().subscribe(res=>{
      this.listaVacinasCombo = res;
    });

    this.formularioPesquisador.get('nome').setValue(pes.nome);
    this.formularioPesquisador.get('idade').setValue(pes.idade);
    this.formularioPesquisador.get('email').setValue(pes.email);
    this.formularioPesquisador.get('cargo').setValue(pes.cargo);
    this.formularioPesquisador.get('id').setValue(pes.id);

    this.vacina.id = pes.vacina.id;
    this.vacina.nomeVacina = pes.vacina.nomeVacina;
  }

  excluirPesquisador(id: any) {
    debugger;
    this.service.excluirPesquisador(id).subscribe(res=>{
      this.listarPesquisador();
    })
  }

  salvarVoluntario() {
    let obj = this.formularioVoluntario.getRawValue();
    obj.paisTeste = {idPaisTeste: this.paisSelecionado.idPaisTeste, nome: this.paisSelecionado.nome, numParticipantes:this.paisSelecionado.numParticipantes};
    this.service.salvarVoluntario(obj).subscribe(res=>{
      window.scrollTo(0, 0);
      this.formularioVoluntario.reset();
      this.sucesso = true;
    })
  }

  listarVoluntarios(){
    this.escopo = 8;
    this.service.listarVoluntarios().subscribe(res=>{
      this.listaVoluntarios = res;
    })
  }

  editarVoluntarios(vol: any){
    this.service.getPaises().subscribe(res=>{
      this.listaPaises = res;
    })
    this.escopo = 9;
    this.formularioVoluntario.get('idVoluntario').setValue(vol.idVoluntario);
    this.formularioVoluntario.get('nome').setValue(vol.nome);
    this.formularioVoluntario.get('idade').setValue(vol.idade);
    this.formularioVoluntario.get('comorbidades').setValue(vol.comorbidades);
  }

  excluirVoluntario(id){
    this.service.excluirVoluntarios(id).subscribe(res=>{
      this.listarVoluntarios();
      window.scrollTo(0, 0);
      this.sucesso = true;
    })
  }

  alterarVoluntario() {
    let obj = this.formularioVoluntario.getRawValue();
    obj.paisTeste = {idPaisTeste: this.paisSelecionado.idPaisTeste, nome: this.paisSelecionado.nome, numParticipantes:this.paisSelecionado.numParticipantes};
    this.service.alterarVoluntario(obj).subscribe(res=>{
      window.scrollTo(0, 0);
      this.formularioVoluntario.reset();
      this.sucesso = true;
    })
  }
}
