package org.proxima.survey.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.proxima.survey.entities.Question;
import org.proxima.survey.entities.QuestionCategory;
import org.proxima.survey.entities.QuestionTag;
import org.proxima.survey.repository.QuestionCategoryJPARepository;
import org.proxima.survey.repository.QuestionTagJPARepository;
import org.proxima.survey.rest.exception.CustomQuestionCategoryError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questionTag")
public class QuestionTagManageRestController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionTagManageRestController.class);

	@Autowired
	private QuestionTagJPARepository questionTagJPARepository;

	@Autowired
	private QuestionCategoryJPARepository questionCategoryRepository;

	@GetMapping("/{id}")
	public ResponseEntity<List<QuestionCategory>> getAllCategoryByQuestion(@PathVariable("id") final Long id) {
		logger.debug("QuestionTagManageRestController.getAllCategoryByQuestion - START");
		List<QuestionTag> questionTag = (List<QuestionTag>) questionTagJPARepository.findByQuestionId(id);
		List<QuestionCategory> qc = new ArrayList<QuestionCategory>();
		for (int i = 0; i < questionTag.size(); i++) {
			Optional<QuestionCategory> optionalObj = questionCategoryRepository.findById(questionTag.get(i).getQuestioncategoryId());
			if (optionalObj.isPresent()) {
				qc.add(optionalObj.get());
			} 
		}
		if (qc.isEmpty()) {
			return new ResponseEntity<List<QuestionCategory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QuestionCategory>>(qc, HttpStatus.OK);
	}
	

	// @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<QuestionTag> createQuestionTag(@Valid @RequestBody
	// final QuestionTag qt) {
	// logger.debug("QuestionTagManageRestController.createQuestionTag - START");
	// questionTagJPARepository.save(qt);
	// return new ResponseEntity<QuestionTag>(qt, HttpStatus.CREATED);
	// }

}
