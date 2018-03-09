package org.proxima.survey.repository;

import java.util.Optional;

import org.proxima.survey.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJPARepository extends JpaRepository<Survey, Long> {
	Optional<Survey> findById(Long id);
	Survey update(Survey s);	
}
