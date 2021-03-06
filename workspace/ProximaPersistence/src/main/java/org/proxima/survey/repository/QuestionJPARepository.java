package org.proxima.survey.repository;

import java.util.Optional;

import org.proxima.survey.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJPARepository extends JpaRepository<Question, Long> {
	// Optional<Question> findById(Long id);
	// List<Question> findAll();
	Optional<Question> findByLabel(String label);
}
