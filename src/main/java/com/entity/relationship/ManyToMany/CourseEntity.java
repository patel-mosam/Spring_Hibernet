package com.entity.relationship.ManyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class CourseEntity {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer courseId;
	
	String courseName;
	
	@ManyToMany
	@JoinTable(name = "student_course" , joinColumns = @JoinColumn(name = "studentId") , inverseJoinColumns = @JoinColumn(name = "courseId"))
	List<StudentEntity> students;

}
