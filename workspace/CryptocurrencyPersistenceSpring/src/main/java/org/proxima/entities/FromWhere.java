package org.proxima.entities;

import java.io.Serializable;
import javax.persistence.*;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String imgpath;

	private String label;

	private String weburl;

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

}