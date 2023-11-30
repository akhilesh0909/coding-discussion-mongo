//package com.ems.codingdiscussion.entities;
//
//import java.util.Date;
//
//import com.ems.codingdiscussion.dtos.AnswerDTO;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.Lob;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//
//@Data
//public class Answers {
//
//	private Long id;
//
//	private String body;
//
//	private Date createdDate;
//
//	private Long userId;
//
//	public AnswerDTO getAnswerDTO() {
//
//		AnswerDTO answerDTO = new AnswerDTO();
//		answerDTO.setId(id);
//		answerDTO.setBody(body);
//		answerDTO.setUserId(userId);
//		answerDTO.setQuestionId(question.getId());
//		answerDTO.setUserName(user.getName());
//		answerDTO.setCreatedDate(createdDate);
//
//		return answerDTO;
//
//	}
//
//}
