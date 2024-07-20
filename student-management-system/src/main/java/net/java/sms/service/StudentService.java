package net.java.sms.service;

import java.util.*;

import net.java.sms.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent( Student student );
	
	Student getStudentById( Long id );
	
	Student updateStudent( Student student );
	
	void removeStudent( Long id );
}
