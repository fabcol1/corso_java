package org.proxima.cc.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * The persistent class for the bitcoinhistorical database table.
 * 
 */
public class BitcoinHistoricalCustom implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private java.math.BigInteger cryptoexchangevaluesproviderid;

	private java.math.BigInteger currencyregistryid;

	private LocalDateTime exchangetime;

	private BigDecimal exchangevalue;
	
	private String providerIconImgpath;

	private String providerLabel;

	private String providerSite;
	
	private String currencyLabel;

	private String currencySymbol;
	
	public BitcoinHistoricalCustom () {}
	
	public BitcoinHistoricalCustom (Long id, BigInteger cryptoexchangevaluesproviderid,
                     BigInteger currencyregistryid, LocalDateTime exchangetime, BigDecimal exchangevalue,
                     String providerIconImgpath, String providerLabel, String providerSite, 
                     String currencyLabel, String currencySymbol) {
		this.id = id;
		this.cryptoexchangevaluesproviderid=cryptoexchangevaluesproviderid;
		this.currencyregistryid=currencyregistryid;
		this.exchangetime=exchangetime;
		this.exchangevalue=exchangevalue;
		this.providerIconImgpath=providerIconImgpath;
		this.providerLabel=providerLabel;
		this.providerSite=providerSite;
		this.currencyLabel=currencyLabel;
		this.currencySymbol=currencySymbol;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cryptoexchangevaluesproviderid
	 */
	public java.math.BigInteger getCryptoexchangevaluesproviderid() {
		return cryptoexchangevaluesproviderid;
	}

	/**
	 * @param cryptoexchangevaluesproviderid the cryptoexchangevaluesproviderid to set
	 */
	public void setCryptoexchangevaluesproviderid(java.math.BigInteger cryptoexchangevaluesproviderid) {
		this.cryptoexchangevaluesproviderid = cryptoexchangevaluesproviderid;
	}

	/**
	 * @return the currencyregistryid
	 */
	public java.math.BigInteger getCurrencyregistryid() {
		return currencyregistryid;
	}

	/**
	 * @param currencyregistryid the currencyregistryid to set
	 */
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

	/**
	 * @return the exchangevalue
	 */
	public BigDecimal getExchangevalue() {
		return exchangevalue;
	}

	/**
	 * @param exchangevalue the exchangevalue to set
	 */
	public void setExchangevalue(BigDecimal exchangevalue) {
		this.exchangevalue = exchangevalue;
	}

	/**
	 * @return the providerIconImgpath
	 */
	public String getProviderIconImgpath() {
		return providerIconImgpath;
	}

	/**
	 * @param providerIconImgpath the providerIconImgpath to set
	 */
	public void setProviderIconImgpath(String providerIconImgpath) {
		this.providerIconImgpath = providerIconImgpath;
	}

	/**
	 * @return the providerLabel
	 */
	public String getProviderLabel() {
		return providerLabel;
	}

	/**
	 * @param providerLabel the providerLabel to set
	 */
	public void setProviderLabel(String providerLabel) {
		this.providerLabel = providerLabel;
	}

	/**
	 * @return the providerSite
	 */
	public String getProviderSite() {
		return providerSite;
	}

	/**
	 * @param providerSite the providerSite to set
	 */
	public void setProviderSite(String providerSite) {
		this.providerSite = providerSite;
	}

	/**
	 * @return the currencyLabel
	 */
	public String getCurrencyLabel() {
		return currencyLabel;
	}

	/**
	 * @param currencyLabel the currencyLabel to set
	 */
	public void setCurrencyLabel(String currencyLabel) {
		this.currencyLabel = currencyLabel;
	}

	/**
	 * @return the currencySymbol
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	/**
	 * @param currencySymbol the currencySymbol to set
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}


}