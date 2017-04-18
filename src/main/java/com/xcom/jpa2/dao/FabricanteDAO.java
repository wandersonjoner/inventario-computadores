package com.xcom.jpa2.dao;

import java.io.Serializable;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.xcom.jpa2.modelo.Fabricante;
import com.xcom.jpa2.service.NegocioException;
import com.xcom.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	// A anotacao @Inject injeta a entidade criada, a entidade Fabricante para manipular no CRUD da classe Data Access Object//
	@Inject
	private EntityManager em;

	// Metodo para salvar o Fabricante //
	public void salvar(Fabricante fabricante) {

		em.merge(fabricante);

	}

	// Metodo para trazer a lista de Fabricante do Banco de Dados //
	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		
		return em.createQuery("from Fabricante").getResultList();

	}

	// Metodo para excluir Fabricante //
	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {

		Fabricante fabricanteTemp = em.find(Fabricante.class, fabricante.getCodigo());
		em.remove(fabricanteTemp);
		em.flush();

	}

	// Metodo para burcar pelo codigo, necessario para realizar a exclusao pelo id do objeto //
	public Fabricante buscarPeloCodigo(Long codigo) {

		return em.find(Fabricante.class, codigo);
	}

}
