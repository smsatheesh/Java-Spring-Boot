package net.java.sms.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import net.java.sms.entity.Student;
import net.java.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// handler method to handle list of students and return mode and view
	@GetMapping("/students")
	public String listOfStudents( Model model ) {
		model.addAttribute( "section", "Student Management Library" );
		model.addAttribute( "students", studentService.getAllStudents());
		return "students";
	}
	
//	@GetMapping("/teachers")
//	public String listOfTeachers( Model model ) {
//		model.addAttribute( "section", "Teacher Management System" );
//		model.addAttribute( "students", studentService.getAllStudents());
//		return "students";
//	}
	
	@GetMapping("/students/new")
	public String createStudentForm( Model model ) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute( "student", student );
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent( @ModelAttribute( "student" ) Student student ) {
		studentService.saveStudent( student );
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm( @PathVariable Long id, Model model ) {
		model.addAttribute ( "student", studentService.getStudentById( id ));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent( @PathVariable Long id, 
								@ModelAttribute( "student" ) Student student, 
								Model model ) {

		// get student details by id
		Student existingStudent = studentService.getStudentById( id );
		existingStudent.setId( student.getId());
		existingStudent.setFirstName( student.getFirstName());
		existingStudent.setLastName( student.getLastName());
		existingStudent.setEmail( student.getEmail());
				
		// save updated student object
		studentService.saveStudent( existingStudent );
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent( @PathVariable Long id ) {
		
		studentService.removeStudent( id );
		return "redirect:/students";
	}
}
