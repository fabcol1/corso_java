package org.proxima.cc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the currencyregistry database table.
 * 
 */
@Entity
@Table(name="currencyregistry")
@NamedQuery(name="CurrencyRegistry.findAll", query="SELECT c FROM CurrencyRegistry c")
public class CurrencyRegistry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String label;

	private String symbol;

	public CurrencyRegistry() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}