package com.cognizant.ormlearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Questions {
	@Id
	@Column(name="qt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="qt_text")
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@OneToMany(mappedBy = "questions", fetch = FetchType.EAGER)

	private Set<AttemptQuestion> attemptQuestionList;
	@OneToMany(mappedBy = "questions", fetch = FetchType.EAGER)

	private Set<Options> optionList;
	public Set<AttemptQuestion> getAttemptQuestionList() {
		return attemptQuestionList;
	}
	public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
		this.attemptQuestionList = attemptQuestionList;
	}
	public Set<Options> getOptionList() {
		return optionList;
	}
	public void setOptionList(Set<Options> optionList) {
		this.optionList = optionList;
	}
	@Override
	public String toString() {
		return "Questions [id=" + id + ", text=" + text + "]";
	}
	
}
