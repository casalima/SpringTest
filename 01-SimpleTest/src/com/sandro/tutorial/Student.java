package com.sandro.tutorial;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class Student {

	@Value("${student.name}")
	private String name;

	@Value("${student.interestedCourse}")
	private String interestedCourse;
	
	@Value("${student.hobby}")
	private String hobby;
	
	@Value("${student.medals}")
	//@Value("gold, silver, bronze")
	private String[] medals;	

	//@Value("Xime")
	public void setName(String name) {
		this.name = name;
		System.out.println("setter: name");
	}
	
	//@Value("Physics")
	public void setInterestedCourse(String interestedCourse) {
		this.interestedCourse = interestedCourse;
		System.out.println("setter: interestedCourse");
	}
	
	//@Value("dancing")
	public void setHobby(String hobby) {
		this.hobby = hobby;
		System.out.println("setter: hobby");
	}
	
	//@Value("${student.medals}")
	//@Value("gold, silver, bronze")
	public void setMedals(String[] medals) {
		this.medals = medals;
	}

	public void showInfo() {
		System.out.println("My name is " + name + ". I study " + interestedCourse + " and practice " + hobby + ". My medals are:");
		for (String medal : medals) {
			System.out.println("- " + medal);
		}
	}
	
}
