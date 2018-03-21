package org.proxima.survey.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the questiontag database table.
 * 
 */
@Entity
@Table(name = "questiontag")
@NamedQuery(name = "QuestionTag.findAll", query = "SELECT q FROM QuestionTag q")
public class QuestionTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_tag_map_id")
	private Long questionTagMapId;

	@Column(name = "question_id")
	private Long questionId;

	@Column(name = "questioncategory_id")
	private Long questioncategoryId;

	public QuestionTag() {
	}

	public Long getQuestionTagMapId() {
		return this.questionTagMapId;
	}

	public void setQuestionTagMapId(Long questionTagMapId) {
		this.questionTagMapId = questionTagMapId;
	}

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getQuestioncategoryId() {
		return this.questioncategoryId;
	}

	public void setQuestioncategoryId(Long questioncategoryId) {
		this.questioncategoryId = questioncategoryId;
	}

}