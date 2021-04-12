package br.com.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity  /*ANOTAÇÃO NECESSARIA PARA CONEXÃO COM BD*/
public class Numero implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id /*ID PARA CONTROLE NO BANCO DE DADOS E CONTROLADOR */
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String elemento;
	private String emRomano;
	
	
	
	public String getEmRomano() {
		return emRomano;
	}
	public void setEmRomano(String emRomano) {
		this.emRomano = emRomano;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
	
}
