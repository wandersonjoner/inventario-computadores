package com.xcom.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.xcom.jpa2.modelo.Fabricante;
import com.xcom.jpa2.service.CadastroFabricanteService;
import com.xcom.jpa2.service.NegocioException;
import com.xcom.jpa2.util.jsf.FacesUtil;

// @Named: Qualificador baseado em String //
@Named

// o escopo de visão é responsavel por enviar a visao para o JSF //
@ViewScoped

// Os Beans sao classes reposnsaveis pela comunicao entre a classe DAO e o JSF
public class CadastroFabricanteBean implements Serializable {

	// Se o serialVersionUID utilizado durante a serialização não bater
	// exatamente com o serialVersionUID da classe que está sendo usada para
	// recuperar essa informação, uma exception é lançada:
	// java.io.InvalidClassException. //
	private static final long serialVersionUID = 1L;

	// A anotacao @Inject injeta a classe CadastroFabricanteService //
	@Inject
	private CadastroFabricanteService cadastroFabricanteService;

	private Fabricante fabricante;

	// Metodo de Salvar que atraves do Inject do Cadastro, vai se comunicar com
	// a classe DAO, fazendo um insert no banco //
	public void salvar() {

		try {
			this.cadastroFabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo");
			this.limpar();
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	// O método anotado com @PostConstruct é executado toda vez que o
	// ManagedBean for instanciado, logo após a execução do construtor da
	// classe. //
	@PostConstruct
	public void inicializar() {

		this.limpar();

	}

	// Esse metodo limpa a caixa texto depois que salvar o Fabricante //
	public void limpar() {

		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
