package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name="estudiante")
public class Estudiante {
	
	public Estudiante() {
	}
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cUsuario;
	
	@Column(name="nombre",nullable=false,length=50)
	@Size(min=1,max=50)
	private String nombre;
	
	@Column(name="apellido",nullable=false,length=50)
	@Size(min=1,max=50,message="Ingrese apellido")
	private String apellido;
	
	@Column(name="carne",nullable=false,length=10)
	@Pattern(regexp = "^[0-9]{8}$",message="Ingrese un numero valido de carnet")
	private String carne;
	
	@Column(name="carrera",nullable=false,length=100)
	@Size(min=1,max=50,message="Ingrese carrera")
	private String carrera;

	public Integer getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
}
