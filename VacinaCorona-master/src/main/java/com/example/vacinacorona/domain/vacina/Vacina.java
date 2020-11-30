package com.example.vacinacorona.domain.vacina;

import com.example.vacinacorona.domain.efeitosColaterais.EfeitosColaterais;
import com.example.vacinacorona.domain.empresa.Empresa;
import com.example.vacinacorona.domain.fasesVacina.FasesVacina;
import com.example.vacinacorona.domain.governo.Governo;
import com.example.vacinacorona.domain.paisTeste.PaisTeste;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @Column(name = "idvacina")
    private Long id;

    @Column(name = "nome_vacina")
    private String nomeVacina;

    @Column(name = "estoque")
    private String estoque;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_fase_vacina")
    private FasesVacina fasesVacina;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "vacina_has_efeitos_colaterais",
            joinColumns = {@JoinColumn(name = "idvacina")},
            inverseJoinColumns = {@JoinColumn(name = "idefeitos_colaterais")})
    private List<EfeitosColaterais> efeitosColaterais;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_governo")
    private Governo governo;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "vacina_has_país_teste",
            joinColumns = {@JoinColumn(name = "idvacina")},
            inverseJoinColumns = {@JoinColumn(name = "id_pais_teste")})
    private List<PaisTeste> paisesTeste;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public FasesVacina getFasesVacina() {
		return fasesVacina;
	}

	public void setFasesVacina(FasesVacina fasesVacina) {
		this.fasesVacina = fasesVacina;
	}

	public List<EfeitosColaterais> getEfeitosColaterais() {
		return efeitosColaterais;
	}

	public void setEfeitosColaterais(List<EfeitosColaterais> efeitosColaterais) {
		this.efeitosColaterais = efeitosColaterais;
	}

	public Governo getGoverno() {
		return governo;
	}

	public void setGoverno(Governo governo) {
		this.governo = governo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<PaisTeste> getPaisesTeste() {
		return paisesTeste;
	}

	public void setPaisesTeste(List<PaisTeste> paisesTeste) {
		this.paisesTeste = paisesTeste;
	}
    
    
}
