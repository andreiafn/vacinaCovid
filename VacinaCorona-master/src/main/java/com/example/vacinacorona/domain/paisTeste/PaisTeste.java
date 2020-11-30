package com.example.vacinacorona.domain.paisTeste;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "pais_teste")
public class PaisTeste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais_teste")
    private Long idPaisTeste;

    private String nome;

    @Column(name = "num_participantes")
    private String numParticipantes;

	public Long getIdPaisTeste() {
		return idPaisTeste;
	}

	public void setIdPaisTeste(Long idPaisTeste) {
		this.idPaisTeste = idPaisTeste;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumParticipantes() {
		return numParticipantes;
	}

	public void setNumParticipantes(String numParticipantes) {
		this.numParticipantes = numParticipantes;
	}
    
    
}
