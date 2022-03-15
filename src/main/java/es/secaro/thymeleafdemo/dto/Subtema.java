package es.secaro.thymeleafdemo.dto;

import java.util.List;

public class Subtema {
	private String descripcion;
	private List<Criterio> criterios;
	public Subtema() {
		super();
	}
	public Subtema(String descripcion, List<Criterio> criterios) {
		super();
		this.descripcion = descripcion;
		this.criterios = criterios;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Criterio> getCriterios() {
		return criterios;
	}
	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}
}