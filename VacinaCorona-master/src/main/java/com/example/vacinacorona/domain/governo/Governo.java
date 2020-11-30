package com.example.vacinacorona.domain.governo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "governo")
public class Governo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_governo")
    private Long idGoverno;
    private String nome;
    
	public Long getIdGoverno() {
		return idGoverno;
	}
	public void setIdGoverno(Long idGoverno) {
		this.idGoverno = idGoverno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
