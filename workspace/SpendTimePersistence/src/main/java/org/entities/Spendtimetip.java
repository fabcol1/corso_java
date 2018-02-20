package org.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the spendtimetips database table.
 * 
 */
@Entity
@Table(name="spendtimetips")
@NamedQuery(name="Spendtimetip.findAll", query="SELECT s FROM Spendtimetip s")
public class Spendtimetip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descrizione;

	private String label;

	//bi-directional many-to-one association to Spendtime
	@OneToMany(mappedBy="spendtimetip")
	private List<Spendtime> spendtimes;

	public Spendtimetip() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Spendtime> getSpendtimes() {
		return this.spendtimes;
	}

	public void setSpendtimes(List<Spendtime> spendtimes) {
		this.spendtimes = spendtimes;
	}

	public Spendtime addSpendtime(Spendtime spendtime) {
		getSpendtimes().add(spendtime);
		spendtime.setSpendtimetip(this);

		return spendtime;
	}

	public Spendtime removeSpendtime(Spendtime spendtime) {
		getSpendtimes().remove(spendtime);
		spendtime.setSpendtimetip(null);

		return spendtime;
	}

}