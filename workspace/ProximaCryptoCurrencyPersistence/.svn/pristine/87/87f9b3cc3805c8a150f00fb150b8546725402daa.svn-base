package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cryptoexchangevaluesprovider database table.
 * 
 */
@Entity
@Table(name="cryptoexchangevaluesprovider")
@NamedQuery(name="CryptoExchangeValuesProvider.findAll", query="SELECT c FROM CryptoExchangeValuesProvider c")
public class CryptoExchangeValuesProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String imgpath;

	private String label;

	private String site;

	public CryptoExchangeValuesProvider() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgpath() {
		return this.imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}