package com.xcom.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.xcom.jpa2.dao.ModeloComputadorDAO;
import com.xcom.jpa2.modelo.ModeloComputador;
import com.xcom.jpa2.util.jpa.Transactional;

public class CadastroModeloComputadorService implements Serializable {
	


	@Inject
	private ModeloComputadorDAO modeloComputadorDAO;

	@Transactional
	public void salvar(ModeloComputador modeloComputador) throws NegocioException {

		if (modeloComputador.getDescricao() == null || modeloComputador.getDescricao().trim().equals("")) {

			throw new NegocioException("O Modelo Computador é obrigatório");

		}
		
		if(modeloComputador.getFabricante()==null){
			
			throw new NegocioException("O Fabricante é obrigatorio");
			
		}
		
		if(modeloComputador.getCategoria()==null){
			
			throw new NegocioException("A categoria é obrigatoria");
			
		}
		
		this.modeloComputadorDAO.salvar(modeloComputador);

	}

}
