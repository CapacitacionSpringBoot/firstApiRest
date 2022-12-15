package com.in28minutes.springboot.firstApiRest.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyResource {
	
	private SurveyService surveyService;
	
	public SurveyResource(SurveyService surveyService) {
		this.surveyService = surveyService;
	}
	
	@RequestMapping(value = "/surveys")
	public List<Survey> retriveAllSurveys(){
		return surveyService.retriveAllSurveys();
	}
	
	@RequestMapping(value = "/surveys/{surveyId}")
	public Survey retriveSurveyById(@PathVariable String surveyId){
		Survey survey = surveyService.retriveSurveyById(surveyId);
		
		if(survey == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return survey;
	}
	
	@RequestMapping(value = "/surveys/{surveyId}/questions")
	public List<Question> retriveAllSurveyQuestions(@PathVariable String surveyId){
		List<Question> questions = surveyService.retriveAllSurveyQuestions(surveyId);
		
		if(questions == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return questions;
	}
	
	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}")
	public List<Question> retriveSpecificSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId){
		Question question = surveyService.retriveSpecificSurveyQuestion(surveyId, questionId);
		
		if(question == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return question;
	}
}
