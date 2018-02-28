package org.proxima.spendtime.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the spendtimetips database table.
 * 
 */
@Entity
@Table(name="spendtimetips")
@NamedQuery(name="SpendTimeTip.findAll", query="SELECT s FROM SpendTimeTip s")
public class SpendTimeTip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descrizione;

	private String label;

	//bi-directional many-to-one association to SpendTime
	@OneToMany(mappedBy="spendtimetip", fetch=FetchType.EAGER)
	private List<SpendTime> spendtimes;

	public SpendTimeTip() {
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

	public List<SpendTime> getSpendtimes() {
		return this.spendtimes;
	}

	public void setSpendtimes(List<SpendTime> spendtimes) {
		this.spendtimes = spendtimes;
	}

	public SpendTime addSpendtime(SpendTime spendtime) {
		getSpendtimes().add(spendtime);
		spendtime.setSpendtimetip(this);

		return spendtime;
	}

	public SpendTime removeSpendtime(SpendTime spendtime) {
		getSpendtimes().remove(spendtime);
		spendtime.setSpendtimetip(null);

		return spendtime;
	}

}