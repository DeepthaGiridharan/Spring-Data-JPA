package com.cognizant.ormlearn.model;

import java.util.Date;
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
@Table(name="attempt")
public class Attempt {
	@Id
	@Column(name="at_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="at_date")
	private Date at_date;
	@Column(name="at_score")
	private double score;
	@ManyToOne
	@JoinColumn(name="at_us_id")
	private User user;
	@OneToMany(mappedBy = "attempt", fetch = FetchType.EAGER)

	private Set<AttemptQuestion> attemptQuestionList;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<AttemptQuestion> getAttemptQuestionList() {
		return attemptQuestionList;
	}
	public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) {
		this.attemptQuestionList = attemptQuestionList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAt_date() {
		return at_date;
	}
	public void setAt_date(Date at_date) {
		this.at_date = at_date;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Attempt [id=" + id + ", at_date=" + at_date + ", score=" + score + "]";
	}

}
