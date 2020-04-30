package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	
	private Integer id; 
	
	private String subType; 
	private int questionOrder;
	private String difficultyLevel;
	private String question;
	private String Answer;
	
	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", subType=" + subType + ", questionOrder=" + questionOrder + ", difficultyLevel="
				+ difficultyLevel + ", question=" + question + ", Answer=" + Answer + "]";
	}
	public Question(Integer id, String subType, int questionOrder, String difficultyLevel, String question,
			String answer) {
		super();
		this.id = id;
		this.subType = subType;
		this.questionOrder = questionOrder;
		this.difficultyLevel = difficultyLevel;
		this.question = question;
		Answer = answer;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public int getQuestionOrder() {
		return questionOrder;
	}
	public void setQuestionOrder(int questionOrder) {
		this.questionOrder = questionOrder;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	
	
	

}
