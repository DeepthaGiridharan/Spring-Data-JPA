package com.cognizant.ormlearn.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="attempt_question")
public class AttemptQuestion {
	@Id
	@Column(name="aq_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="aq_at_id")
	private Attempt attempt;
	@ManyToOne
	@JoinColumn(name="aq_qt_id")
	private Questions questions;
	@OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.EAGER)

	private Set<AttemptOption> attemptOptionList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Attempt getAttempt() {
		return attempt;
	}
	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}
	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

}
