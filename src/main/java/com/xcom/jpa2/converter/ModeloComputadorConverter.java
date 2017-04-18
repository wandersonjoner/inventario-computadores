package com.xcom.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.xcom.jpa2.dao.ModeloComputadorDAO;
import com.xcom.jpa2.modelo.ModeloComputador;
import com.xcom.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=ModeloComputador.class)
public class ModeloComputadorConverter implements Converter{

	ModeloComputadorDAO modeloComputadorDAO;

	public ModeloComputadorConverter() {

		modeloComputadorDAO = CDIServiceLocator.getBean(ModeloComputadorDAO.class);

	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloComputador retorno = null;

		if (value != null) {

			retorno = this.modeloComputadorDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {

			Long codigo = ((ModeloComputador) value).getCodigo();
			return codigo == null ? null : codigo.toString();

		}
		return "";
	}

}
