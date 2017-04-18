package com.xcom.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.xcom.jpa2.dao.FabricanteDAO;
import com.xcom.jpa2.modelo.Categoria;
import com.xcom.jpa2.modelo.Fabricante;
import com.xcom.jpa2.modelo.ModeloComputador;
import com.xcom.jpa2.service.CadastroModeloComputadorService;
import com.xcom.jpa2.service.NegocioException;
import com.xcom.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloComputadorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ModeloComputador modeloComputador;

	private List<Fabricante> fabricantes;

	private List<Categoria> categorias;

	@Inject
	private CadastroModeloComputadorService cadastroModeloComputadorService;

	@Inject
	private FabricanteDAO fabricanteDAO;

	public void salvar() {
		try {
			this.cadastroModeloComputadorService.salvar(modeloComputador);
			FacesUtil.addSuccessMessage("Modelo salvo");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias = Arrays.asList(Categoria.values());
	}

	public void limpar() {

		this.modeloComputador = new ModeloComputador();
	}

	public ModeloComputador getModeloComputador() {
		return modeloComputador;
	}

	public void setModeloComputador(ModeloComputador modeloComputador) {
		this.modeloComputador = modeloComputador;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
