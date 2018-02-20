package org.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the spendtime database table.
 * 
 */
@Entity
@NamedQuery(name="Spendtime.findAll", query="SELECT s FROM Spendtime s")
public class Spendtime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String data;

	private int ora;

	//bi-directional many-to-one association to Spendtimetip
	@ManyToOne
	@JoinColumn(name="tipoOre")
	private Spendtimetip spendtimetip;

	public Spendtime() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getOra() {
		return this.ora;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public Spendtimetip getSpendtimetip() {
		return this.spendtimetip;
	}

	public void setSpendtimetip(Spendtimetip spendtimetip) {
		this.spendtimetip = spendtimetip;
	}

}