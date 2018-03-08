package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_valuta database table.
 * 
 */
@Entity
@Table(name="tipo_valuta")
@NamedQuery(name="TipoValuta.findAll", query="SELECT t FROM TipoValuta t")
public class TipoValuta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String label;

	private String simbolo;

	public TipoValuta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

}