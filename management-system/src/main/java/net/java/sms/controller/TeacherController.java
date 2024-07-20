package net.java.sms.controller;

import org.springframework.web.bind.annotation.*;

import net.java.sms.entity.Teacher;
import net.java.sms.service.TeacherService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TeacherController {

	private TeacherService teacherService;

	public TeacherController( TeacherService teacherService ) {
		super();
		this.teacherService = teacherService;
	}
	
	@GetMapping("/teachers")
	public String listOfTeachers( Model model ) {
		model.addAttribute( "section", "Teacher Management System" );
		model.addAttribute( "teachers", teacherService.getListOfAllTeachers());
		return "teachers";
	}
	
	@GetMapping("/teachers/new")
	public String createTeacherForm( Model model ) {
		
		Teacher teacher = new Teacher();
		model.addAttribute( "section", "Teacher Management System" );
		model.addAttribute( "teacher", teacher );
		return "create_teacher";
	}
	
	@PostMapping("/teachers")
	public String saveStudent( @ModelAttribute("teacher") Teacher teacher ) {
		
		teacherService.saveTeacher( teacher );
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm( @PathVariable("id") Long id, Model model ) {
		
		model.addAttribute( "section", "Teacher Management System" );
		model.addAttribute( "teacher", teacherService.getTeacherById( id ));
		return "edit_teacher";
	}
	
	@PostMapping("/teachers/{id}")
	public String updateTeacher(
				@PathVariable("id") Long id,
				@ModelAttribute("teachers") Teacher teacher,
				Model model
			) {
		
		model.addAttribute( "section", "Teacher Management System" );
		
		Teacher existingTeacher = teacherService.getTeacherById( id );
		existingTeacher.setId( teacher.getId());
		existingTeacher.setFirstName( teacher.getFirstName());
		existingTeacher.setLastName( teacher.getLastName());
		existingTeacher.setEmail( teacher.getEmail());
		existingTeacher.setDepartment( teacher.getDepartment());
		
		teacherService.updateTeacher( existingTeacher );
		return "redirect:/teachers";
	}
	
	@GetMapping("teachers/{id}")
	public String removeTeacher( @PathVariable("id") Long id ) {
		teacherService.removeTeacher( id );
		return "redirect:/teachers";
	}
}
