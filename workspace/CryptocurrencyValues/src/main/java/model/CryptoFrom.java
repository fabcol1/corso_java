package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the crypto_from database table.
 * 
 */
@Entity
@Table(name="crypto_from")
@NamedQuery(name="CryptoFrom.findAll", query="SELECT c FROM CryptoFrom c")
public class CryptoFrom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="from_where")
	private String fromWhere;

	//bi-directional many-to-one association to CryptoValute
	@OneToMany(mappedBy="cryptoFrom")
	private List<CryptoValute> cryptoValutes;

	public CryptoFrom() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromWhere() {
		return this.fromWhere;
	}

	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
	}

	public List<CryptoValute> getCryptoValutes() {
		return this.cryptoValutes;
	}

	public void setCryptoValutes(List<CryptoValute> cryptoValutes) {
		this.cryptoValutes = cryptoValutes;
	}

	public CryptoValute addCryptoValute(CryptoValute cryptoValute) {
		getCryptoValutes().add(cryptoValute);
		cryptoValute.setCryptoFrom(this);

		return cryptoValute;
	}

	public CryptoValute removeCryptoValute(CryptoValute cryptoValute) {
		getCryptoValutes().remove(cryptoValute);
		cryptoValute.setCryptoFrom(null);

		return cryptoValute;
	}

}