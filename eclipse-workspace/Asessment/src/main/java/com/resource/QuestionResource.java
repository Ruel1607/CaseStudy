package com.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Question;
import com.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionResource {
@Autowired
 private QuestionRepository qRepo ; 

	
	@GetMapping("questions/{id}")
	public Optional<Question> retrieveQuestion(@PathVariable int id){
		
		Optional<Question> question = this.qRepo.findById(id);
		return question;
		
	}
	@GetMapping("questions")
	public List<Question> retrieveAllsubtype(@RequestParam (defaultValue = "all") String subType){ 
		String stype = subType.toUpperCase();
		if (subType.equals("all")) {
			
			return(List<Question>) qRepo.findAll();
		}
		return(List<Question>) qRepo.findBySubType(stype);
	
	}	
	@GetMapping("difficulty")
	
	public  List<Question> getDiff(@RequestParam String diffLevel){
		
		return(List<Question>) qRepo.findByDifficultyLevel(diffLevel);
	}
	
}