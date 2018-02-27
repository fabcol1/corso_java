package org.proxima.survey.utility;

import java.util.ArrayList;
import java.util.List;

import org.proxima.survey.db.QuestionnairePersistence;
import org.proxima.survey.db.SurveyUtils;
import org.proxima.survey.entities.Questionnaire;
import org.proxima.survey.entities.Reply;
import org.proxima.survey.entities.Survey;
import org.proxima.survey.frontutils.QuestionCorrection;
import org.proxima.survey.frontutils.QuestionInfo;

public class RetrieverUtility {
	
	public static void main(String args[]) {
		List<QuestionInfo> ques = getQuestionInfos();
		ques.forEach(q -> System.out.println(q.getQuestion()));
	}
	
	/**
	 * Public method used by frontend to request question infos
	 * @return List<QuestionInfo>
	 */
	public static List<QuestionInfo>  getQuestionInfos() {
		List<Survey> questions = SurveyUtils.selectAllSurveys();
		List<QuestionInfo> result = new ArrayList<>();
		QuestionInfo tmp;
		for (Survey s : questions) {
			tmp = convertQuestion(s);
			result.add(tmp);
		}
		return result;
	}
	
	public static QuestionInfo getSingleQuestionInfo(int id) {
		Survey survey = SurveyUtils.selectSurvey(id);
		QuestionInfo tmp = convertQuestion(survey);
		return tmp;
	}
	
	private static QuestionInfo convertQuestion(Survey s) {
		QuestionInfo tmp = new QuestionInfo(Integer.toString(s.getId()), s.getQuestion(), new String[6]);
		tmp.getAnswers()[0] = s.getAnsa();
		tmp.getAnswers()[1] = s.getAnsb();
		tmp.getAnswers()[2] = s.getAnsc();
		tmp.getAnswers()[3] = s.getAnsd();
		tmp.getAnswers()[4] = s.getAnse();
		tmp.getAnswers()[5] = s.getAnsf();
		return tmp;
	}

	/**
	 * Public method used by frontend to request question corrections.
	 * @return
	 */
	public static List<QuestionCorrection> getQuestionCorrection() {
		List<Survey> questions = SurveyUtils.selectAllSurveys();
		List<QuestionCorrection> result = new ArrayList<>();
		QuestionCorrection tmp;
		List<String> correctAnswers;
		for (Survey s : questions) {
			tmp = new QuestionCorrection();
			tmp.setQuestionID(Integer.toString(s.getId()));
			correctAnswers = new ArrayList<>();
			if(s.getCansa() == true)
				correctAnswers.add("AnsA");
			if(s.getCansb() == true)
				correctAnswers.add("AnsB");
			if(s.getCansc() == true)
				correctAnswers.add("AnsC");
			if(s.getCansd() == true) 
				correctAnswers.add("AnsD");
			if(s.getCanse() == true)
				correctAnswers.add("AnsE");
			if(s.getCansf() == true)
				correctAnswers.add("AnsF");
			tmp.setAnswers(correctAnswers.toArray(new String[0]));
			result.add(tmp);
		}
		return result;
	}
	
	public static void insertReply(Reply reply) {
		QuestionnairePersistence.insertReply(reply);
	}
	
	public static void insertQuestionnaire(Questionnaire questionnaire) {
		QuestionnairePersistence.insertQuestionnaire(questionnaire);
	}

	public static void updateQuestionnaire(int idQuestionnaire, int idReply) {
		Questionnaire questionnaire = QuestionnairePersistence.selectQuestionnaire(idQuestionnaire);
		StringBuilder replies = new StringBuilder(questionnaire.getReplies());
		replies.deleteCharAt(replies.indexOf("]"));
		replies.append(", " + idReply + "]");
		questionnaire.setReplies(replies.toString());
		QuestionnairePersistence.updateQuestionnaire(questionnaire);
	}
}
