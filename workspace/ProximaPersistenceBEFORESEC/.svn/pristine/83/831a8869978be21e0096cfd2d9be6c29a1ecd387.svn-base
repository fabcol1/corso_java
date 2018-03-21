package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the questioncategory database table.
 * 
 */
@Entity
@Table(name = "questioncategory")
@NamedQuery(name = "QuestionCategory.findAll", query = "SELECT q FROM QuestionCategory q")
public class QuestionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String label;

	// bi-directional many-to-one association to QuestionTag
	// @OneToMany(mappedBy = "questioncategory")
	// private List<QuestionTag> questiontags;

	public QuestionCategory() {
	}

	public QuestionCategory(int id) {
		this.id = (long) id;
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
	// questiontag.setQuestioncategory(this);
	//
	// return questiontag;
	// }
	//
	// public QuestionTag removeQuestiontag(QuestionTag questiontag) {
	// getQuestiontags().remove(questiontag);
	// questiontag.setQuestioncategory(null);
	//
	// return questiontag;
	// }

}