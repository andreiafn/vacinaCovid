package com.example.vacinacorona.domain.fasesVacina;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "fases_vacina")
public class FasesVacina {

    @Id
    @Column(name = "idfases_vacina")
    private Long id;

    @Column(name = "fase1")
    private String fase1;

    @Column(name = "fase2")
    private String fase2;

    @Column(name = "fase3")
    private String fase3;

    @Column(name = "fase4")
    private String fase4;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFase1() {
		return fase1;
	}

	public void setFase1(String fase1) {
		this.fase1 = fase1;
	}

	public String getFase2() {
		return fase2;
	}

	public void setFase2(String fase2) {
		this.fase2 = fase2;
	}

	public String getFase3() {
		return fase3;
	}

	public void setFase3(String fase3) {
		this.fase3 = fase3;
	}

	public String getFase4() {
		return fase4;
	}

	public void setFase4(String fase4) {
		this.fase4 = fase4;
	}
}
