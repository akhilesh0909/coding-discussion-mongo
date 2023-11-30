//package com.ems.codingdiscussion.entities;
//
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
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
//import org.springframework.data.mongodb.core.mapping.Document;
//
//
//@Data
//@Document
//public class Image {
//
//	private long id;
//
//	private String name;
//
//	private String type;
//
//	private byte[] data;
//
//
//	@JsonIgnore
//	private Answers answer;
//}
