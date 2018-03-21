package org.proxima.survey.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.proxima.survey.entities.Question;
import org.proxima.survey.entities.Survey;
import org.proxima.survey.entities.SurveyReply;
import org.proxima.survey.repository.SurveyJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SurveyEvaluator {
	
	@Autowired
	private SurveyJPARepository surveyRepository;

	public int evaluate(SurveyReply sr) {
		int count = 0;
		int result = 0;
		Optional<Survey> optSurvey = surveyRepository.findById(sr.getSurveyId());
		Survey survey = optSurvey.isPresent() ? optSurvey.get() : null;
		Map<Long, List<String>> givenReplies = getAnswersJson(sr.getAnswers());
		Question qTemp = null;
		
		for (Long id : givenReplies.keySet()) {
			for(int i = 0; i < survey.getSurveyquestions().size(); i++) {
				if(survey.getSurveyquestions().get(i).getQuestion().getId().equals(id)) {
					qTemp = survey.getSurveyquestions().get(i).getQuestion();
					break;
				}
			}
			for(String str : givenReplies.get(id)) {
				switch(str) {
				case "answerA": if(qTemp.getCansa())
									count++; break;
				case "answerB": if(qTemp.getCansb())
									count++; break;	
				case "answerC": if(qTemp.getCansc())
									count++; break;
				case "answerD": if(qTemp.getCansd())
									count++; break;
				case "answerE": if(qTemp.getCanse())
									count++; break;
				case "answerF": if(qTemp.getCansf())
									count++; break;
				}
				if(count == qTemp.getCountCorrectAnswers())
					result++;
				count = 0;
			}
		}
		
		return result;
	}
	
	public Map<Long, List<String>> getAnswersJson(String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode json = null;
		try {
			json = objectMapper.readTree(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonNode temp = null;
		Map<Long, List<String>> result = new HashMap<>();
		Long qTemp;
		List<String> ansTemp;
		for (int i = 0; json.hasNonNull(i); i++) {
			temp = json.get(i);
			qTemp = temp.get("questionId").asLong();
			ansTemp = new ArrayList<>();
			for(int j=0; temp.get("answers").hasNonNull(j); j++) {
				ansTemp.add(temp.get("answers").get(j).asText());
			}
			result.put(qTemp, ansTemp);
		}
		return result;		
	}

}
