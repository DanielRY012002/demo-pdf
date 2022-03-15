package es.secaro.thymeleafdemo.dto;

import java.util.List;

public class Subcriterio {
	private String descripcion;
	private List<Table02> criterios;
	public Subcriterio() {
		super();
	}
	public Subcriterio(String descripcion, List<Table02> criterios) {
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
	public List<Table02> getCriterios() {
		return criterios;
	}
	public void setCriterios(List<Table02> criterios) {
		this.criterios = criterios;
	}
}