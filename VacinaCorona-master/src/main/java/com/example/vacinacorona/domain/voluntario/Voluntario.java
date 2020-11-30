package com.example.vacinacorona.domain.voluntario;

import com.example.vacinacorona.domain.paisTeste.PaisTeste;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Data
@Entity
@Table(name = "voluntario")
public class Voluntario {

    @Id
    @Column(name = "idvoluntario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoluntario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private String idade;

    @Column(name = "comorbidades")
    private String comorbidades;

    @OneToOne
    @JoinColumn(name = "id_pais_teste")
    private PaisTeste paisTeste;

	public Long getIdVoluntario() {
		return idVoluntario;
	}

	public void setIdVoluntario(Long idVoluntario) {
		this.idVoluntario = idVoluntario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getComorbidades() {
		return comorbidades;
	}

	public void setComorbidades(String comorbidades) {
		this.comorbidades = comorbidades;
	}

	public PaisTeste getPaisTeste() {
		return paisTeste;
	}

	public void setPaisTeste(PaisTeste paisTeste) {
		this.paisTeste = paisTeste;
	}
}
