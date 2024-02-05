package com.springboot.app.springboot.first.app;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping(value="/student")
	public Student getStud() {
		return new Student("Jayasree","Mathireddi");
	}
	
	//http://localhost:8080/studentList
	@GetMapping(value="/studentList")
	public List<Student> getStudentList(){
		List<Student> studentList=new ArrayList<>();
		studentList.add(new Student("A","Naidu"));
		studentList.add(new Student("B","Reddy"));
		studentList.add(new Student("C","Chowdary"));
		studentList.add(new Student("D","varma"));
		return studentList;
	}
	
	
	//@PathVariable Annotation
	//http://localhost:8080/student/mounika/mathireddi
	@GetMapping("/student/{firstName1}/{lastName1}")
	public Student StudentpathVariable(@PathVariable("firstName1")String firstName,
			@PathVariable("lastName1")String lastName) {
		return new Student(firstName,lastName);
	}
	
	//build restAPI to handle query parameters
	//RequestParam Annotation
	//http://localhost:8080/student/query?firstName=Abhinav&lastName=Dogga
	@GetMapping("/student/query")
	public Student StudentQueryParam(@RequestParam(name="firstName")String firstName,
			@RequestParam(name="lastName")String lastName) {
		return new Student(firstName,lastName);
		
		
	}
}
