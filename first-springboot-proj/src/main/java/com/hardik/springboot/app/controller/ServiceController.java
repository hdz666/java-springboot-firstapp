package com.hardik.springboot.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hardik.springboot.app.model.Question;
import com.hardik.springboot.app.service.SurveyService;

@RestController
class SurveyController {
	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value ="/surveys/{surveyId}/questions",method = RequestMethod.GET)
	public List<Question> retrieveQuestionsforSurvey(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}

	@RequestMapping(value ="/surveys/{surveyId}/questions",method = RequestMethod.POST)
	public ResponseEntity<?> addQuestionsforSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion) {
		 
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		if(question==null) {
			return ResponseEntity.noContent().build();
		}
		 //uri
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();
		 
		//status
		 return ResponseEntity.created(location).build(); 
	}
	
	@GetMapping(path = "/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveQuestion(@PathVariable String surveyId,
            @PathVariable String questionId) {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }

}
