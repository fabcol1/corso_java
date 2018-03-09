package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * The persistent class for the bitcoinhistorical database table.
 * 
 */
@Entity
@Table(name="bitcoinhistorical")
@NamedQuery(name="BitcoinHistorical.findAll", query="SELECT b FROM BitcoinHistorical b")
public class BitcoinHistorical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private java.math.BigInteger cryptoexchangevaluesproviderid;

	private java.math.BigInteger currencyregistryid;

	private LocalDateTime exchangetime;

	private BigDecimal exchangevalue;

	public BitcoinHistorical() {
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

	/**
	 * @return the exchangetime
	 */
	public LocalDateTime getExchangetime() {
		return exchangetime;
	}

	/**
	 * @param exchangetime the exchangetime to set
	 */
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