package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the crypto_valute database table.
 * 
 */
@Entity
@Table(name="crypto_valute")
@NamedQuery(name="CryptoValute.findAll", query="SELECT c FROM CryptoValute c")
public class CryptoValute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_when")
	private Date dataWhen;

	private String tipologia;

	private BigDecimal valore;

	//bi-directional many-to-one association to CryptoFrom
	@ManyToOne
	@JoinColumn(name="from_where")
	private CryptoFrom cryptoFrom;

	public CryptoValute() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataWhen() {
		return this.dataWhen;
	}

	public void setDataWhen(Date dataWhen) {
		this.dataWhen = dataWhen;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public BigDecimal getValore() {
		return this.valore;
	}

	public void setValore(BigDecimal valore) {
		this.valore = valore;
	}

	public CryptoFrom getCryptoFrom() {
		return this.cryptoFrom;
	}

	public void setCryptoFrom(CryptoFrom cryptoFrom) {
		this.cryptoFrom = cryptoFrom;
	}

}