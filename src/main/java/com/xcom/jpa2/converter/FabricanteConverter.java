package com.xcom.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.xcom.jpa2.dao.FabricanteDAO;
import com.xcom.jpa2.modelo.Fabricante;
import com.xcom.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Fabricante.class)
// Converter é o componente do JSF que é responsável por fazer a conversão de um
// objeto para uma String e de uma String para um objeto. //
public class FabricanteConverter implements Converter {

	FabricanteDAO fabricanteDAO;

	public FabricanteConverter() {
		// TODO Auto-generated constructor stub

		fabricanteDAO = CDIServiceLocator.getBean(FabricanteDAO.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Fabricante retorno = null;
		if (value != null) {

			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value != null) {

			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}

		return "";
	}

}
