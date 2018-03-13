package org.proxima.cc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * The persistent class for the litecoinhistorical database table.
 * 
 */
@Entity
@Table(name="litecoinhistorical")
@NamedQuery(name="LitecoinHistorical.findAll", query="SELECT l FROM LitecoinHistorical l")
public class LitecoinHistorical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private java.math.BigInteger cryptoexchangevaluesproviderid;

	private java.math.BigInteger currencyregistryid;

	private LocalDateTime exchangetime;

	private BigDecimal exchangevalue;

	public LitecoinHistorical() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.math.BigInteger getCryptoexchangevaluesproviderid() {
		return this.cryptoexchangevaluesproviderid;
	}

	public void setCryptoexchangevaluesproviderid(java.math.BigInteger cryptoexchangevaluesproviderid) {
		this.cryptoexchangevaluesproviderid = cryptoexchangevaluesproviderid;
	}

	public java.math.BigInteger getCurrencyregistryid() {
		return this.currencyregistryid;
	}

	public void setCurrencyregistryid(java.math.BigInteger currencyregistryid) {
		this.currencyregistryid = currencyregistryid;
	}

	public LocalDateTime getExchangetime() {
		return this.exchangetime;
	}

	public void setExchangetime(LocalDateTime exchangetime) {
		this.exchangetime = exchangetime;
	}

	public BigDecimal getExchangevalue() {
		return this.exchangevalue;
	}

	public void setExchangevalue(BigDecimal exchangevalue) {
		this.exchangevalue = exchangevalue;
	}

}