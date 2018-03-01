package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_valuta database table.
 * 
 */
@Entity
@Table(name="tipo_valuta")
@NamedQuery(name="TipoValuta.findAll", query="SELECT t FROM TipoValuta t")
public class TipoValuta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String label;

	private String simbolo;

	//bi-directional many-to-one association to Bitcoin
	@OneToMany(mappedBy="tipoValuta")
	private List<Bitcoin> bitcoins;

	//bi-directional many-to-one association to Ethereum
	@OneToMany(mappedBy="tipoValuta")
	private List<Ethereum> ethereums;

	//bi-directional many-to-one association to Litecoin
	@OneToMany(mappedBy="tipoValuta")
	private List<Litecoin> litecoins;

	public TipoValuta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public List<Bitcoin> getBitcoins() {
		return this.bitcoins;
	}

	public void setBitcoins(List<Bitcoin> bitcoins) {
		this.bitcoins = bitcoins;
	}

	public Bitcoin addBitcoin(Bitcoin bitcoin) {
		getBitcoins().add(bitcoin);
		bitcoin.setTipoValuta(this);

		return bitcoin;
	}

	public Bitcoin removeBitcoin(Bitcoin bitcoin) {
		getBitcoins().remove(bitcoin);
		bitcoin.setTipoValuta(null);

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
		ethereum.setTipoValuta(this);

		return ethereum;
	}

	public Ethereum removeEthereum(Ethereum ethereum) {
		getEthereums().remove(ethereum);
		ethereum.setTipoValuta(null);

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
		litecoin.setTipoValuta(this);

		return litecoin;
	}

	public Litecoin removeLitecoin(Litecoin litecoin) {
		getLitecoins().remove(litecoin);
		litecoin.setTipoValuta(null);

		return litecoin;
	}

}