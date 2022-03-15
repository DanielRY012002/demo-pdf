package es.secaro.thymeleafdemo.dto;

import java.util.List;

public class Criterio {
	private String descripcion;
	private List<Pregunta> preguntas;
	public Criterio() {
		super();
	}
	public Criterio(String descripcion, List<Pregunta> preguntas) {
		super();
		this.descripcion = descripcion;
		this.preguntas = preguntas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
}