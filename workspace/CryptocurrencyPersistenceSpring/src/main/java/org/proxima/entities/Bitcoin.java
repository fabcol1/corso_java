package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "error.cambioValore.null")
	@Column(name="cambio_valore")
	private BigDecimal cambioValore;

	@NotNull(message = "error.dataValore.null")
	@Column(name="data_valore")
	private LocalDateTime dataValore;

	@NotNull(message = "error.idFrom.null")
	@Column(name="id_from")
	private int idFrom;

	@NotNull(message = "error.idValuta.null")
	@Column(name="id_valuta")
	private int idValuta;

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

	public int getIdFrom() {
		return this.idFrom;
	}

	public void setIdFrom(int idFrom) {
		this.idFrom = idFrom;
	}

	public int getIdValuta() {
		return this.idValuta;
	}

	public void setIdValuta(int idValuta) {
		this.idValuta = idValuta;
	}

}