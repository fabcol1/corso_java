package org.proxima.spendtime.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the spendtime database table.
 * 
 */
@Entity
@Table(name="spendtime")
@NamedQuery(name="SpendTime.findAll", query="SELECT s FROM SpendTime s")
public class SpendTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String data;

	private int ora;

	private int userID;

	//bi-directional many-to-one association to SpendTimeTip
	@ManyToOne
	@JoinColumn(name="tipoOre")
	private SpendTimeTip spendtimetip;

	public SpendTime() {
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

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public SpendTimeTip getSpendtimetip() {
		return this.spendtimetip;
	}

	public void setSpendtimetip(SpendTimeTip spendtimetip) {
		this.spendtimetip = spendtimetip;
	}

}