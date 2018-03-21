package org.proxima.survey.rest;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.proxima.survey.entities.Question;
import org.proxima.survey.entities.QuestionTag;
import org.proxima.survey.entities.SurveyQuestion;
import org.proxima.survey.helper.QuestionConverter;
import org.proxima.survey.repository.QuestionJPARepository;
import org.proxima.survey.repository.QuestionTagJPARepository;
import org.proxima.survey.repository.SurveyQuestionJPARepository;
import org.proxima.survey.rest.bean.RequestQuestion;
import org.proxima.survey.rest.exception.CustomQuestionError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionManageRestController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionManageRestController.class);

	@Autowired
	private QuestionJPARepository questionRepository;
	@Autowired
	private QuestionTagJPARepository questionTagJPARepository;
	@Autowired
	private SurveyQuestionJPARepository surveyQuestionJPARepository;

	@GetMapping("/")
	public ResponseEntity<List<Question>> getAllQuestion() {
		logger.debug("QuestionManageRestController.getAllQuestion - START");
		List<Question> question = (List<Question>) questionRepository.findAll();
		if (question.isEmpty()) {
			return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionyById(@PathVariable("id") final Long id) {
		logger.debug("QuestionManageRestController.getQuestionyById - START");
		Optional<Question> optionalObj = questionRepository.findById(id);
		if (!optionalObj.isPresent()) {
			return new ResponseEntity<Question>(new CustomQuestionError("Question with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Question>(optionalObj.get(), HttpStatus.OK);
		}

	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> updateQuestion(@PathVariable("id") final long id,
			@RequestBody final RequestQuestion q) {
		logger.debug("QuestionManageRestController.updateQuestion - START");
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		if (!optionalQuestion.isPresent()) {
			return new ResponseEntity<Question>(new CustomQuestionError("Question with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		} else {
			// Question question = optionalQuestion.get();
			Question questionToInsert = QuestionConverter.questionFromRequestToEntity(q);
			questionToInsert.setId(q.getId());
			questionRepository.save(questionToInsert);
			List<QuestionTag> newtag = q.getQuestiontags();
			List<QuestionTag> oldtag = (List<QuestionTag>) questionTagJPARepository.findByQuestionId(id);
			if ((oldtag != null) && (!oldtag.isEmpty())) {
				Boolean checked = false;
				// INSERIMENTO NUOVA CAT
				for (QuestionTag newTag : newtag) {
					checked = true;
					for (QuestionTag oldTag : oldtag) {
						if (newTag.getQuestioncategoryId() == oldTag.getQuestioncategoryId()) {
							checked = false;
						}
					}
					if (checked) {
						QuestionTag tagToSave = new QuestionTag();
						tagToSave.setQuestionId(questionToInsert.getId());
						tagToSave.setQuestioncategoryId(newTag.getQuestioncategoryId());
						QuestionTag qt = questionTagJPARepository.save(tagToSave);
					}
				}

				// ELIMINAZIONE CAT
				for (QuestionTag oldTag : oldtag) {
					checked = true;
					for (QuestionTag newTag : newtag) {
						if (oldTag.getQuestioncategoryId() == newTag.getQuestioncategoryId()) {
							checked = false;
						}
					}
					if (checked) {
						questionTagJPARepository.delete(oldTag);
					}
				}
			} else {
				for (QuestionTag newTag : newtag) {
					QuestionTag tagToSave = new QuestionTag();
					tagToSave.setQuestionId(questionToInsert.getId());
					tagToSave.setQuestioncategoryId(newTag.getQuestioncategoryId());
					QuestionTag qt = questionTagJPARepository.save(tagToSave);
				}
			}

			return new ResponseEntity<Question>(questionToInsert, HttpStatus.OK);
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Question> deleteQuestion(@PathVariable("id") final Long id) {
		logger.debug("QuestionManageRestController.deleteQuestion - START");
		Optional<Question> question = questionRepository.findById(id);
		if (!question.isPresent()) {
			return new ResponseEntity<Question>(new CustomQuestionError("Question with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		} else {
			System.out.println("aa1");
			List<SurveyQuestion> surveyQuestion = (List<SurveyQuestion>) surveyQuestionJPARepository.findByQuestionId(id);
			if (surveyQuestion.isEmpty()) {
				System.out.println("aa2");

				questionTagJPARepository.deleteByQuestionId(id);
				questionRepository.deleteById(id);
				return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
			}
			System.out.println("aa3");

			return new ResponseEntity<Question>(question.get(),HttpStatus.OK);
		}
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RequestQuestion> createQuestion(@Valid @RequestBody final RequestQuestion q) {
		logger.debug("QuestionManageRestController.createQuestion - START");
		Question questionToInsert = QuestionConverter.questionFromRequestToEntity(q);
		questionRepository.save(questionToInsert);
		logger.debug("QuestionManageRestController.createQuestion - DEBUG 1");
		List<QuestionTag> qtList = q.getQuestiontags();
		if ((qtList != null) && (!qtList.isEmpty())) {
			for (QuestionTag tag : qtList) {
				QuestionTag tagToSave = new QuestionTag();
				logger.debug("QuestionManageRestController.createQuestion - DEBUG 2 - questionToInsert.getId(): "
						+ questionToInsert.getId() + " - tag.getQuestioncategoryId(): " + tag.getQuestioncategoryId());
				tagToSave.setQuestionId(questionToInsert.getId());
				tagToSave.setQuestioncategoryId(tag.getQuestioncategoryId());
				QuestionTag qt = questionTagJPARepository.save(tagToSave);
			}
		}

		return new ResponseEntity<RequestQuestion>(q, HttpStatus.CREATED);
	}
}
