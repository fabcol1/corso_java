package org.proxima.survey.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table(name = "question")
@NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "error.ansa.empty")
	@NotEmpty(message = "error.ansa.empty")
	@Length(max = 255, message = "error.ansa.length")
	private String ansa;

	@NotNull(message = "error.ansb.empty")
	@NotEmpty(message = "error.ansb.empty")
	@Length(max = 255, message = "error.ansb.length")
	private String ansb;

	@NotNull(message = "error.ansc.empty")
	@NotEmpty(message = "error.ansc.empty")
	@Length(max = 255, message = "error.ansc.length")
	private String ansc;

	@NotNull(message = "error.ansd.empty")
	@NotEmpty(message = "error.ansd.empty")
	@Length(max = 255, message = "error.ansd.length")
	private String ansd;

	@NotNull(message = "error.anse.empty")
	@NotEmpty(message = "error.anse.empty")
	@Length(max = 255, message = "error.anse.length")
	private String anse;

	@NotNull(message = "error.ansf.empty")
	@NotEmpty(message = "error.ansf.empty")
	@Length(max = 255, message = "error.ansf.length")
	private String ansf;

	@NotNull(message = "error.cansa.empty")
	private Boolean cansa;

	@NotNull(message = "error.cansb.empty")
	private Boolean cansb;

	@NotNull(message = "error.cansc.empty")
	private Boolean cansc;

	@NotNull(message = "error.cansd.empty")
	private Boolean cansd;

	@NotNull(message = "error.canse.empty")
	private Boolean canse;

	@NotNull(message = "error.cansf.empty")
	private Boolean cansf;

	@NotNull(message = "error.description.empty")
	@NotEmpty(message = "error.description.empty")
	@Length(max = 255, message = "error.description.length")
	private String description;

	@NotNull(message = "error.label.empty")
	@NotEmpty(message = "error.label.empty")
	@Length(max = 50, message = "error.label.length")
	private String label;

	// bi-directional many-to-one association to SurveyQuestion
	// @OneToMany(mappedBy="question")
	// private List<SurveyQuestion> surveyquestions;

	// bi-directional many-to-one association to QuestionTag
	// @JsonManagedReference
	// @OneToMany(mappedBy="question")
	// private List<QuestionTag> questiontags;

	public Question() {
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append("Question: \n" + description + "\nAnswers:\n");
		String[] literals = {"A", "B", "C", "D", "E", "F"};
		String[] answers = {ansa, ansb, ansc, ansd, anse, ansf};
		Boolean[] trueAnswers = {cansa, cansb, cansc, cansd, canse, cansf};
		for (int i = 0; i < answers.length; i++) {
			str.append(literals[i] + " " + answers[i] + "\n");
		}
		str.append("These are the correct answers:\n");
		for (int i = 0; i < trueAnswers.length; i++) {
			if(trueAnswers[i]) {
				str.append(literals[i] + " ");
			}
		}
		str.append("\n");
		return str.toString();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public Boolean getCansa() {
		return this.cansa;
	}

	public void setCansa(Boolean cansa) {
		this.cansa = cansa;
	}

	public Boolean getCansb() {
		return this.cansb;
	}

	public void setCansb(Boolean cansb) {
		this.cansb = cansb;
	}

	public Boolean getCansc() {
		return this.cansc;
	}

	public void setCansc(Boolean cansc) {
		this.cansc = cansc;
	}

	public Boolean getCansd() {
		return this.cansd;
	}

	public void setCansd(Boolean cansd) {
		this.cansd = cansd;
	}

	public Boolean getCanse() {
		return this.canse;
	}

	public void setCanse(Boolean canse) {
		this.canse = canse;
	}

	public Boolean getCansf() {
		return this.cansf;
	}

	public void setCansf(Boolean cansf) {
		this.cansf = cansf;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public int getCountCorrectAnswers() {
		int result = 0;
		if(this.getCansa())
			result++;
		if(this.getCansb())
			result++;
		if(this.getCansc())
			result++;
		if(this.getCansd())
			result++;
		if(this.getCanse())
			result++;
		if(this.getCansf())
			result++;
		return result;
	}

	// public List<SurveyQuestion> getSurveyquestions() {
	// return this.surveyquestions;
	// }
	//
	// public void setSurveyquestions(List<SurveyQuestion> surveyquestions) {
	// this.surveyquestions = surveyquestions;
	// }

	// public SurveyQuestion addSurveyquestion(SurveyQuestion surveyquestion) {
	// getSurveyquestions().add(surveyquestion);
	// surveyquestion.setQuestion(this);
	//
	// return surveyquestion;
	// }
	//
	// public SurveyQuestion removeSurveyquestion(SurveyQuestion surveyquestion) {
	// getSurveyquestions().remove(surveyquestion);
	// surveyquestion.setQuestion(null);
	//
	// return surveyquestion;
	// }

	// public List<QuestionTag> getQuestiontags() {
	// return this.questiontags;
	// }
	//
	// public void setQuestiontags(List<QuestionTag> questiontags) {
	// this.questiontags = questiontags;
	// }
	//
	// public QuestionTag addQuestiontag(QuestionTag questiontag) {
	// getQuestiontags().add(questiontag);
	// questiontag.setQuestion(this);
	//
	// return questiontag;
	// }
	//
	// public QuestionTag removeQuestiontag(QuestionTag questiontag) {
	// getQuestiontags().remove(questiontag);
	// questiontag.setQuestion(null);
	//
	// return questiontag;
	// }

}