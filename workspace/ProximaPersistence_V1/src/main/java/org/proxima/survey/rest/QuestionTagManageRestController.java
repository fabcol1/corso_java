package org.proxima.survey.rest;

import java.util.List;

import javax.validation.Valid;

import org.proxima.survey.entities.Question;
import org.proxima.survey.entities.QuestionCategory;
import org.proxima.survey.entities.QuestionTag;
import org.proxima.survey.repository.QuestionTagJPARepository;
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

//	@GetMapping("/{id}")
//	public ResponseEntity<List<QuestionCategory>> getAllCategoryByQuestion(@PathVariable("id") final Long id) {
//		logger.debug("QuestionTagManageRestController.getAllCategoryByQuestion - START");
//		Question q = new Question();
//		q.setId(id);
//		List<QuestionCategory> questionCategory = (List<QuestionCategory>) questionTagJPARepository.findByQuestion(q);
//		if (questionCategory.isEmpty()) {
//			return new ResponseEntity<List<QuestionCategory>>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<QuestionCategory>>(questionCategory, HttpStatus.OK);
//	}
	
//	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<QuestionTag> createQuestionTag(@Valid @RequestBody final QuestionTag qt) {
//		logger.debug("QuestionTagManageRestController.createQuestionTag - START");
//		questionTagJPARepository.save(qt);
//		return new ResponseEntity<QuestionTag>(qt, HttpStatus.CREATED);
//	}

}
