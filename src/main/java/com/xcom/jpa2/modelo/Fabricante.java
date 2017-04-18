package com.xcom.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// A anotacao @Entity é responsavel por gerar a entidade Fabricante que é uma tabela do Banco de Dados //
@Entity
public class Fabricante {

	// Declaracao de variaveis //
	private Long codigo;
	private String nome;

	// A anotacao @Id é responsavel por criar nossa chavre primaria//
	@Id

	// A anotacao @ @GeneratedValue é responsável por criar a estratégia de
	// comunicacao com o Banco de Dados, o GenerationType.IDENTITY se comunica
	// com o Mysql //
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Hash Equals no id/codigo é para saber qual é o id correto do Fabricante,
	// sem ele o converter nao funciona, nao consegue converter.//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
