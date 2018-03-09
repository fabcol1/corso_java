package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the survey database table.
 * 
 */
@Entity
@NamedQuery(name="Survey.findAll", query="SELECT s FROM Survey s")
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String label;

	//bi-directional many-to-one association to SurveyQuestion
	@OneToMany(mappedBy="survey")
	private List<SurveyQuestion> surveyquestions;

	public Survey() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<SurveyQuestion> getSurveyquestions() {
		return this.surveyquestions;
	}

	public void setSurveyquestions(List<SurveyQuestion> surveyquestions) {
		this.surveyquestions = surveyquestions;
	}

	public SurveyQuestion addSurveyquestion(SurveyQuestion surveyquestion) {
		getSurveyquestions().add(surveyquestion);
		surveyquestion.setSurvey(this);

		return surveyquestion;
	}

	public SurveyQuestion removeSurveyquestion(SurveyQuestion surveyquestion) {
		getSurveyquestions().remove(surveyquestion);
		surveyquestion.setSurvey(null);

		return surveyquestion;
	}

}