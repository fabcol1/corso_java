package org.proxima.cc.entities.ethereum;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The persistent class for the ethereumHistoricalAverage database table.
 * 
 */
@Entity
@Table(name="ethereumhistoricalaverages")
@NamedQuery(name="EthereumHistoricalAverage.findAll", query="SELECT b FROM EthereumHistoricalAverage b")
public class EthereumHistoricalAverage implements Serializable {
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

	public EthereumHistoricalAverage() {
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
		return "EthereumHistoricalAverage [id=" + id + ", cryptoexchangevaluesproviderid="
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