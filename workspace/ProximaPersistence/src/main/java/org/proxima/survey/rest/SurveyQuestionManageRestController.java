package org.proxima.survey.rest;

import java.util.List;

import org.proxima.survey.entities.Question;
import org.proxima.survey.entities.SurveyQuestion;
import org.proxima.survey.repository.SurveyQuestionJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/surveyQuestion")
public class SurveyQuestionManageRestController {

	private static final Logger logger = LoggerFactory.getLogger(SurveyQuestionManageRestController.class);

	@Autowired
	private SurveyQuestionJPARepository surveyQuestionJPARepository;


//	@GetMapping("/{id}")
//	public ResponseEntity<List<SurveyQuestion>> getByQuestion(@PathVariable("id") final Long id) {
//		logger.debug("SurveyQuestionManageRestController.getByQuestion - START");
//		List<SurveyQuestion> surveyQuestion = (List<SurveyQuestion>) surveyQuestionJPARepository.findByQuestionId(id);
//
//		if (surveyQuestion.isEmpty()) {
//			return new ResponseEntity<List<SurveyQuestion>>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<SurveyQuestion>>(surveyQuestion, HttpStatus.OK);
//	}
	

}
