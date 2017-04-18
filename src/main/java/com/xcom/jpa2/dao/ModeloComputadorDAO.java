package com.xcom.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.xcom.jpa2.modelo.ModeloComputador;
import com.xcom.jpa2.service.NegocioException;
import com.xcom.jpa2.util.jpa.Transactional;
import com.xcom.jpa2.util.jsf.FacesUtil;

public class ModeloComputadorDAO implements Serializable {

	

	@Inject
	private EntityManager manager;

	public void salvar(ModeloComputador modeloComputador) {

		manager.merge(modeloComputador);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloComputador> buscarTodos() {

		return manager.createQuery("from ModeloComputador").getResultList();
	}

	public ModeloComputador buscarPeloCodigo(Long codigo) {

		return manager.find(ModeloComputador.class, codigo);

	}

	@Transactional
	public void excluir(ModeloComputador modeloComputador) throws NegocioException {

		modeloComputador = buscarPeloCodigo(modeloComputador.getCodigo());

		try {
			manager.remove(modeloComputador);
			manager.flush();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			FacesUtil.addSuccessMessage("O Modelo nao pode ser excluido");
		}

	}

}
