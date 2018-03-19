package org.proxima.survey.repository;

import java.util.List;

import org.proxima.survey.entities.Question;
import org.proxima.survey.entities.QuestionCategory;
import org.proxima.survey.entities.QuestionTag;
import org.proxima.survey.entities.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyQuestionJPARepository extends JpaRepository<SurveyQuestion, Long> {
	List<SurveyQuestion> findByQuestionId(Long id);
}

