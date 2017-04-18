package com.xcom.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.xcom.jpa2.dao.FabricanteDAO;
import com.xcom.jpa2.modelo.Fabricante;
import com.xcom.jpa2.service.NegocioException;
import com.xcom.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// A anotacao @Inject injeta aos metodos da classe FabricanteDAO //
	@Inject
	FabricanteDAO fabricanteDAO;

	// cria uma lista de fabricantes //
	private List<Fabricante> fabricantes = new ArrayList<>();

	// variavel fabricanteSelecionado, vamos utilizar para excluir o Fabricante
	// //
	private Fabricante fabricanteSelecionado;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	// Metodo para excluir o Fabricante através da classe FabricanteDAO usando o
	// objeto fabricanteSelecionado. //
	public void excluir() {

		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante excluido!");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

	@PostConstruct
	public void inicializar() {

		fabricantes = fabricanteDAO.buscarTodos();
	}

}
