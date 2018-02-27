package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the survey database table.
 * 
 */
@Entity
@Table(name="survey")
@NamedQuery(name="Survey.findAll", query="SELECT s FROM Survey s")
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String ansa;

	private String ansb;

	private String ansc;

	private String ansd;

	private String anse;

	private String ansf;

	private boolean cansa;

	private boolean cansb;

	private boolean cansc;

	private boolean cansd;

	private boolean canse;

	private boolean cansf;

	private String question;

	public Survey() {
		this.ansa = new String();
		this.ansb = new String();
		this.ansc = new String();
		this.ansd = new String();
		this.anse = new String();
		this.ansf = new String();
		this.question = new String();
		
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ansa == null) ? 0 : ansa.hashCode());
		result = prime * result + ((ansb == null) ? 0 : ansb.hashCode());
		result = prime * result + ((ansc == null) ? 0 : ansc.hashCode());
		result = prime * result + ((ansd == null) ? 0 : ansd.hashCode());
		result = prime * result + ((anse == null) ? 0 : anse.hashCode());
		result = prime * result + ((ansf == null) ? 0 : ansf.hashCode());
		result = prime * result + (cansa ? 1231 : 1237);
		result = prime * result + (cansb ? 1231 : 1237);
		result = prime * result + (cansc ? 1231 : 1237);
		result = prime * result + (cansd ? 1231 : 1237);
		result = prime * result + (canse ? 1231 : 1237);
		result = prime * result + (cansf ? 1231 : 1237);
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (ansa == null) {
			if (other.ansa != null)
				return false;
		} else if (!ansa.equals(other.ansa))
			return false;
		if (ansb == null) {
			if (other.ansb != null)
				return false;
		} else if (!ansb.equals(other.ansb))
			return false;
		if (ansc == null) {
			if (other.ansc != null)
				return false;
		} else if (!ansc.equals(other.ansc))
			return false;
		if (ansd == null) {
			if (other.ansd != null)
				return false;
		} else if (!ansd.equals(other.ansd))
			return false;
		if (anse == null) {
			if (other.anse != null)
				return false;
		} else if (!anse.equals(other.anse))
			return false;
		if (ansf == null) {
			if (other.ansf != null)
				return false;
		} else if (!ansf.equals(other.ansf))
			return false;
		if (cansa != other.cansa)
			return false;
		if (cansb != other.cansb)
			return false;
		if (cansc != other.cansc)
			return false;
		if (cansd != other.cansd)
			return false;
		if (canse != other.canse)
			return false;
		if (cansf != other.cansf)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnsa() {
		return this.ansa;
	}

	public void setAnsa(String ansa) {
		this.ansa = ansa;
	}

	public String getAnsb() {
		return this.ansb;
	}

	public void setAnsb(String ansb) {
		this.ansb = ansb;
	}

	public String getAnsc() {
		return this.ansc;
	}

	public void setAnsc(String ansc) {
		this.ansc = ansc;
	}

	public String getAnsd() {
		return this.ansd;
	}

	public void setAnsd(String ansd) {
		this.ansd = ansd;
	}

	public String getAnse() {
		return this.anse;
	}

	public void setAnse(String anse) {
		this.anse = anse;
	}

	public String getAnsf() {
		return this.ansf;
	}

	public void setAnsf(String ansf) {
		this.ansf = ansf;
	}

	public boolean getCansa() {
		return this.cansa;
	}

	public void setCansa(boolean cansa) {
		this.cansa = cansa;
	}

	public boolean getCansb() {
		return this.cansb;
	}

	public void setCansb(boolean cansb) {
		this.cansb = cansb;
	}

	public boolean getCansc() {
		return this.cansc;
	}

	public void setCansc(boolean cansc) {
		this.cansc = cansc;
	}

	public boolean getCansd() {
		return this.cansd;
	}

	public void setCansd(boolean cansd) {
		this.cansd = cansd;
	}

	public boolean getCanse() {
		return this.canse;
	}

	public void setCanse(boolean canse) {
		this.canse = canse;
	}

	public boolean getCansf() {
		return this.cansf;
	}

	public void setCansf(boolean cansf) {
		this.cansf = cansf;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setLike(Survey s) {
		
		if(!this.getQuestion().equals(s.getQuestion()))
			this.setQuestion(s.getQuestion());
		
		if(!this.getAnsa().equals(s.getAnsa()))
			this.setAnsa(s.getAnsa());
		
		if(!this.getAnsb().equals(s.getAnsb()))
			this.setAnsb(s.getAnsb());
		
		if(!this.getAnsc().equals(s.getAnsc()))
			this.setAnsc(s.getAnsc());
		
		if(!this.getAnsd().equals(s.getAnsd()))
			this.setAnsd(s.getAnsd());
		
		if(!this.getAnse().equals(s.getAnse()))
			this.setAnse(s.getAnse());
		
		if(!this.getAnsf().equals(s.getAnsf()))
			this.setAnsf(s.getAnsf());
		
		if(!this.getCansa() == s.getCansa())
			this.setCansa(s.getCansa());
		
		if(this.getCansb() != s.getCansb())
			this.setCansb(s.getCansb());
		
		if(this.getCansc() != s.getCansc())
			this.setCansc(s.getCansc());
		
		if(this.getCansd() != s.getCansd())
			this.setCansd(s.getCansd());
		
		if(this.getCanse() != s.getCanse())
			this.setCanse(s.getCanse());
		
		if(this.getCansf() != s.getCansf())
			this.setCansf(s.getCansf());
	}

}