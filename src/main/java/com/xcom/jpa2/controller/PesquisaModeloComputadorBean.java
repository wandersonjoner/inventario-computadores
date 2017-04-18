package com.xcom.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.xcom.jpa2.dao.ModeloComputadorDAO;
import com.xcom.jpa2.modelo.ModeloComputador;
import com.xcom.jpa2.service.NegocioException;
import com.xcom.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaModeloComputadorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ModeloComputador> modelosComputador;

	private ModeloComputador modeloComputadorSelecionado;

	@Inject
	private ModeloComputadorDAO modeloComputadorDAO;

	public List<ModeloComputador> getModelosComputador() {
		return modelosComputador;
	}

	public void excluir() {

		try {
			modeloComputadorDAO.excluir(modeloComputadorSelecionado);
			this.modelosComputador.remove(modeloComputadorSelecionado);
			FacesUtil.addSuccessMessage("Modelo excluido");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public ModeloComputador getModeloComputadorSelecionado() {
		return modeloComputadorSelecionado;
	}

	public void setModeloComputadorSelecionado(ModeloComputador modeloComputadorSelecionado) {
		this.modeloComputadorSelecionado = modeloComputadorSelecionado;
	}

	@PostConstruct
	public void inicializar() {

		modelosComputador = modeloComputadorDAO.buscarTodos();
	}

}
