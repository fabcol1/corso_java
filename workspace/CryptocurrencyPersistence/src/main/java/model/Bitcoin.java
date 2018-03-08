package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * The persistent class for the bitcoin database table.
 * 
 */
@Entity
@NamedQuery(name="Bitcoin.findAll", query="SELECT b FROM Bitcoin b")
public class Bitcoin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="cambio_valore")
	private BigDecimal cambioValore;

//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_valore")
	private LocalDateTime dataValore;

	//bi-directional many-to-one association to FromWhere
	@ManyToOne
	@JoinColumn(name="id_from")
	private FromWhere fromWhere;

	//bi-directional many-to-one association to TipoValuta
	@ManyToOne
	@JoinColumn(name="id_valuta")
	private TipoValuta tipoValuta;

	public Bitcoin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCambioValore() {
		return this.cambioValore;
	}

	public void setCambioValore(BigDecimal cambioValore) {
		this.cambioValore = cambioValore;
	}

	public LocalDateTime getDataValore() {
		return this.dataValore;
	}

	public void setDataValore(LocalDateTime dataValore) {
		this.dataValore = dataValore;
	}

	public FromWhere getFromWhere() {
		return this.fromWhere;
	}

	public void setFromWhere(FromWhere fromWhere) {
		this.fromWhere = fromWhere;
	}

	public TipoValuta getTipoValuta() {
		return this.tipoValuta;
	}

	public void setTipoValuta(TipoValuta tipoValuta) {
		this.tipoValuta = tipoValuta;
	}

	public String toString() {
		return getId() + " - " + getCambioValore() + " - " + getDataValore();
	}
}