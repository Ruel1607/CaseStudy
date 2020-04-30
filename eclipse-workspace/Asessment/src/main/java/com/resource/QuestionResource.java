package com.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.model.Question;
import com.repository.QuestionRepository;

import java.net.URI;
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
	
	@PutMapping("questions/{id}")
	public ResponseEntity<Object> editQuestion(@RequestBody Question question,@PathVariable int id){
		
		
		Optional<Question> questionOptional = qRepo.findById(id);
		if (!questionOptional.isPresent())
			return ResponseEntity.notFound().build();
		
		
	question.setId(id);	
	Question editQuestion = qRepo.save(question);
		
	URI location =	ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(editQuestion.getId()).toUri(); 
	
		return ResponseEntity.created(location).build();
		
	}
	@PostMapping("questions")
	public ResponseEntity<Object> createQuestion(@RequestBody Question question){
		
		
		
		
		Question createQuestion = qRepo.save(question);
		
		URI location =	ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createQuestion.getId()).toUri(); 
		
			return ResponseEntity.created(location).build();
		
	}
	
	
	
	
	
}