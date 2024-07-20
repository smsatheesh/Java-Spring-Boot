package net.java.sms.service;

import java.util.List;

import net.java.sms.entity.Teacher;

public interface TeacherService {

	List<Teacher> getListOfAllTeachers();
	
	Teacher saveTeacher( Teacher teacher );
	
	Teacher getTeacherById( Long id );
	
	Teacher updateTeacher( Teacher teacher );
	
	void removeTeacher( Long id );
}
