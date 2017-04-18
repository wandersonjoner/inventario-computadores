package com.xcom.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.xcom.jpa2.dao.FabricanteDAO;
import com.xcom.jpa2.modelo.Fabricante;
import com.xcom.jpa2.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// A anotacao @Inject injeta o FabricanteDAO // 
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	// A anotacao @Transational é responsavel pela transacao entre o metodo salvar do FabricanteDAO e o metodo salvar da classe CadastrofabricanteService //
	@Transactional
	public void salvar(Fabricante fabricante)throws NegocioException{
		
		// Esse se. Verifica se o nome do Fabricante esta nulo ou com o preenchimento vazio //
		if(fabricante.getNome()==null||fabricante.getNome().trim().equals("")){
			
			// se salvar e nao digitar, vai receber esta mensagem abaixo //
			throw new NegocioException("O Fabricante é obrigatório!");
			
		}
		// aqui eu chamo o metodo salvar da classe FabricanteDAO, passando como parametro o objeto Fabricante. //
		this.fabricanteDAO.salvar(fabricante);
		
	}

}
