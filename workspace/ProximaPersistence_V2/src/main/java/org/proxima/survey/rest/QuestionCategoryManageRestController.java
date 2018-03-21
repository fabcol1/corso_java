package org.proxima.survey.rest;

import java.util.List;
import java.util.Optional;

import org.proxima.survey.entities.QuestionCategory;
import org.proxima.survey.repository.QuestionCategoryJPARepository;
import org.proxima.survey.rest.exception.CustomQuestionCategoryError;
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
@RequestMapping("/api/questionCategory")
public class QuestionCategoryManageRestController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionCategoryManageRestController.class);

	@Autowired
	private QuestionCategoryJPARepository questionCategoryRepository;

	@GetMapping("/")
	public ResponseEntity<List<QuestionCategory>> getAllQuestionCategory() {
		logger.debug("QuestionCategoryManageRestController.getAllQuestionCategory - START");
		List<QuestionCategory> questionCategory = (List<QuestionCategory>) questionCategoryRepository.findAll();
		if (questionCategory.isEmpty()) {
			return new ResponseEntity<List<QuestionCategory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QuestionCategory>>(questionCategory, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<QuestionCategory> getQuestionCategoryById(@PathVariable("id") final Long id) {
		logger.debug("QuestionManageRestController.getQuestionCategoryById - START");
		Optional<QuestionCategory> optionalObj = questionCategoryRepository.findById(id);
		if (!optionalObj.isPresent()) {
			return new ResponseEntity<QuestionCategory>(
					new CustomQuestionCategoryError("QuestionCategory with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<QuestionCategory>(optionalObj.get(), HttpStatus.OK);
		}

	}

}
