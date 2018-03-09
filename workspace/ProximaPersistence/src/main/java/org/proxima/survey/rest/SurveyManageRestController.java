package org.proxima.survey.rest;

import java.util.Optional;

import org.proxima.survey.entities.Survey;
import org.proxima.survey.repository.SurveyJPARepository;
import org.proxima.survey.rest.exception.CustomSurveyError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey")
public class SurveyManageRestController {

	private static final Logger logger = LoggerFactory.getLogger(SurveyManageRestController.class);
	
	@Autowired
	private SurveyJPARepository surveyRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Survey> getSurveyById (@PathVariable("id") final Long id) {
		logger.debug("SurveyManageRestController.getSurvey - START");
		Optional<Survey> optionalObj = surveyRepository.findById(id);
		if (!optionalObj.isPresent()) {
            return new ResponseEntity<Survey>(new CustomSurveyError("Survey with id " + id + " not found"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Survey> (optionalObj.get(), HttpStatus.OK) ;	
		}
		
	}
	
	
	@PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Survey> updateSurvey (
			@PathVariable("id") final long id,
			@RequestBody final Survey u) {
		
		Optional<Survey> optionalSurvey = surveyRepository.findById(id);
		if (!optionalSurvey.isPresent()) {
            return new ResponseEntity<Survey>(new CustomSurveyError("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		} else {
			Survey survey = optionalSurvey.get();
			survey.setDescription(u.getDescription());
			survey.setLabel(u.getLabel());
			surveyRepository.save(survey);
			return new ResponseEntity<Survey>(survey, HttpStatus.OK);
		}
	}
}
