package org.proxima.cc.entities.litecoin;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The persistent class for the litecoinhistorical database table.
 * 
 */
@Entity
@Table(name = "litecoinhistorical")
@NamedQuery(name = "LitecoinHistorical.findAll", query = "SELECT l FROM LitecoinHistorical l")
public class LitecoinHistorical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long cryptoexchangevaluesproviderid;

	private Long currencyregistryid;

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

	/**
	 * @return the cryptoexchangevaluesproviderid
	 */
	public Long getCryptoexchangevaluesproviderid() {
		return cryptoexchangevaluesproviderid;
	}

	/**
	 * @param cryptoexchangevaluesproviderid
	 *            the cryptoexchangevaluesproviderid to set
	 */
	public void setCryptoexchangevaluesproviderid(Long cryptoexchangevaluesproviderid) {
		this.cryptoexchangevaluesproviderid = cryptoexchangevaluesproviderid;
	}

	/**
	 * @return the currencyregistryid
	 */
	public Long getCurrencyregistryid() {
		return currencyregistryid;
	}

	/**
	 * @param currencyregistryid
	 *            the currencyregistryid to set
	 */
	public void setCurrencyregistryid(Long currencyregistryid) {
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