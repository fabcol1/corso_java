package org.proxima.survey.repository;

import org.proxima.survey.entities.SurveyReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyReplyJPARepository extends JpaRepository<SurveyReply, Long> {
	
}
