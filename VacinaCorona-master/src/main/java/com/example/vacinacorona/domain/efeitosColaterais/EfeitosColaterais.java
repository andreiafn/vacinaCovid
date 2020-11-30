package com.example.vacinacorona.domain.efeitosColaterais;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "efeitos_colaterais")
public class EfeitosColaterais {

    @Id
    @Column(name = "idefeitos_colaterais")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEfeitosColaterais;
    private String comum;
    private String incomum;
    private String raro;
    private String descricao;

    @Transient
    private String tipo;

	public Long getIdEfeitosColaterais() {
		return idEfeitosColaterais;
	}

	public void setIdEfeitosColaterais(Long idEfeitosColaterais) {
		this.idEfeitosColaterais = idEfeitosColaterais;
	}

	public String getComum() {
		return comum;
	}

	public void setComum(String comum) {
		this.comum = comum;
	}

	public String getIncomum() {
		return incomum;
	}

	public void setIncomum(String incomum) {
		this.incomum = incomum;
	}

	public String getRaro() {
		return raro;
	}

	public void setRaro(String raro) {
		this.raro = raro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    
}
