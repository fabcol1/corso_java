package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the surveyquestion database table.
 * 
 */
@Entity
@Table(name = "surveyquestion")
@NamedQuery(name = "SurveyQuestion.findAll", query = "SELECT s FROM SurveyQuestion s")
public class SurveyQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "survey_question_map_id")
	private Long surveyQuestionMapId;

	// bi-directional many-to-one association to Question
	@ManyToOne
	private Question question;

	// bi-directional many-to-one association to Survey
	@ManyToOne
	@JsonBackReference
	private Survey survey;

	public SurveyQuestion() {
	}

	public Long getSurveyQuestionMapId() {
		return this.surveyQuestionMapId;
	}

	public void setSurveyQuestionMapId(Long surveyQuestionMapId) {
		this.surveyQuestionMapId = surveyQuestionMapId;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Survey getSurvey() {
		return this.survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

}