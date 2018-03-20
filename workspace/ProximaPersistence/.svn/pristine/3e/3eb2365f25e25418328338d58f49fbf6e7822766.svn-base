package org.proxima.cc.entities.bitcoin;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The persistent class for the bitcoinhistoricalaverages database table.
 * 
 */
@Entity
@Table(name="bitcoinhistoricalaverages")
@NamedQuery(name="BitcoinHistoricalAverage.findAll", query="SELECT b FROM BitcoinHistoricalAverage b")
public class BitcoinHistoricalAverage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long cryptoexchangevaluesproviderid;

	private Long currencyregistryid;

	private BigDecimal exchangeaverage;

	private LocalDate exchangedate;

	public Long getCryptoexchangevaluesproviderid() {
		return cryptoexchangevaluesproviderid;
	}

	public Long getCurrencyregistryid() {
		return currencyregistryid;
	}

	public LocalDate getExchangedate() {
		return exchangedate;
	}

	public void setCryptoexchangevaluesproviderid(Long cryptoexchangevaluesproviderid) {
		this.cryptoexchangevaluesproviderid = cryptoexchangevaluesproviderid;
	}

	public void setCurrencyregistryid(Long currencyregistryid) {
		this.currencyregistryid = currencyregistryid;
	}

	public void setExchangedate(LocalDate exchangedate) {
		this.exchangedate = exchangedate;
	}

	private BigDecimal exchangemax;

	private BigDecimal exchangemin;

	public BitcoinHistoricalAverage() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public BigDecimal getExchangeaverage() {
		return this.exchangeaverage;
	}

	public void setExchangeaverage(BigDecimal exchangeaverage) {
		this.exchangeaverage = exchangeaverage;
	}

	public BigDecimal getExchangemax() {
		return this.exchangemax;
	}

	public void setExchangemax(BigDecimal exchangemax) {
		this.exchangemax = exchangemax;
	}

	@Override
	public String toString() {
		return "BitcoinHistoricalAverage [id=" + id + ", cryptoexchangevaluesproviderid="
				+ cryptoexchangevaluesproviderid + ", currencyregistryid=" + currencyregistryid + ", exchangeaverage="
				+ exchangeaverage + ", exchangedate=" + exchangedate + ", exchangemax=" + exchangemax + ", exchangemin="
				+ exchangemin + "]";
	}

	public BigDecimal getExchangemin() {
		return this.exchangemin;
	}

	public void setExchangemin(BigDecimal exchangemin) {
		this.exchangemin = exchangemin;
	}
}