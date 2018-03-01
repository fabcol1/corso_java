package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the from_where database table.
 * 
 */
@Entity
@Table(name="from_where")
@NamedQuery(name="FromWhere.findAll", query="SELECT f FROM FromWhere f")
public class FromWhere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String imgpath;

	private String label;

	private String weburl;

	//bi-directional many-to-one association to Bitcoin
	@OneToMany(mappedBy="fromWhere")
	private List<Bitcoin> bitcoins;

	//bi-directional many-to-one association to Ethereum
	@OneToMany(mappedBy="fromWhere")
	private List<Ethereum> ethereums;

	//bi-directional many-to-one association to Litecoin
	@OneToMany(mappedBy="fromWhere")
	private List<Litecoin> litecoins;

	public FromWhere() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getWeburl() {
		return this.weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public List<Bitcoin> getBitcoins() {
		return this.bitcoins;
	}

	public void setBitcoins(List<Bitcoin> bitcoins) {
		this.bitcoins = bitcoins;
	}

	public Bitcoin addBitcoin(Bitcoin bitcoin) {
		getBitcoins().add(bitcoin);
		bitcoin.setFromWhere(this);

		return bitcoin;
	}

	public Bitcoin removeBitcoin(Bitcoin bitcoin) {
		getBitcoins().remove(bitcoin);
		bitcoin.setFromWhere(null);

		return bitcoin;
	}

	public List<Ethereum> getEthereums() {
		return this.ethereums;
	}

	public void setEthereums(List<Ethereum> ethereums) {
		this.ethereums = ethereums;
	}

	public Ethereum addEthereum(Ethereum ethereum) {
		getEthereums().add(ethereum);
		ethereum.setFromWhere(this);

		return ethereum;
	}

	public Ethereum removeEthereum(Ethereum ethereum) {
		getEthereums().remove(ethereum);
		ethereum.setFromWhere(null);

		return ethereum;
	}

	public List<Litecoin> getLitecoins() {
		return this.litecoins;
	}

	public void setLitecoins(List<Litecoin> litecoins) {
		this.litecoins = litecoins;
	}

	public Litecoin addLitecoin(Litecoin litecoin) {
		getLitecoins().add(litecoin);
		litecoin.setFromWhere(this);

		return litecoin;
	}

	public Litecoin removeLitecoin(Litecoin litecoin) {
		getLitecoins().remove(litecoin);
		litecoin.setFromWhere(null);

		return litecoin;
	}

}