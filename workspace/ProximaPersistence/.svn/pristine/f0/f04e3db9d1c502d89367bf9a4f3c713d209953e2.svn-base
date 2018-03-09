package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String ansa;

	private String ansb;

	private String ansc;

	private String ansd;

	private String anse;

	private String ansf;

	private Boolean cansa;

	private Boolean cansb;

	private Boolean cansc;

	private Boolean cansd;

	private Boolean canse;

	private Boolean cansf;

	private String description;

	private String label;

	//bi-directional many-to-one association to SurveyQuestion
//	@OneToMany(mappedBy="question")
//	private List<SurveyQuestion> surveyquestions;

	//bi-directional many-to-one association to QuestionTag
	@OneToMany(mappedBy="question")
	private List<QuestionTag> questiontags;

	public Question() {
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

//	public List<SurveyQuestion> getSurveyquestions() {
//		return this.surveyquestions;
//	}
//
//	public void setSurveyquestions(List<SurveyQuestion> surveyquestions) {
//		this.surveyquestions = surveyquestions;
//	}

//	public SurveyQuestion addSurveyquestion(SurveyQuestion surveyquestion) {
//		getSurveyquestions().add(surveyquestion);
//		surveyquestion.setQuestion(this);
//
//		return surveyquestion;
//	}
//
//	public SurveyQuestion removeSurveyquestion(SurveyQuestion surveyquestion) {
//		getSurveyquestions().remove(surveyquestion);
//		surveyquestion.setQuestion(null);
//
//		return surveyquestion;
//	}

	public List<QuestionTag> getQuestiontags() {
		return this.questiontags;
	}

	public void setQuestiontags(List<QuestionTag> questiontags) {
		this.questiontags = questiontags;
	}

	public QuestionTag addQuestiontag(QuestionTag questiontag) {
		getQuestiontags().add(questiontag);
		questiontag.setQuestion(this);

		return questiontag;
	}

	public QuestionTag removeQuestiontag(QuestionTag questiontag) {
		getQuestiontags().remove(questiontag);
		questiontag.setQuestion(null);

		return questiontag;
	}

}