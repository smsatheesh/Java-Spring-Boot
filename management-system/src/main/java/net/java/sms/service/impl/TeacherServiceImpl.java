package net.java.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.java.sms.entity.Teacher;
import net.java.sms.repository.TeacherRepository;
import net.java.sms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherRepository teacherRepository;
	
	public TeacherServiceImpl( TeacherRepository teacherRepository ) {
		super();
		this.teacherRepository = teacherRepository;
	}
	
	public List<Teacher> getListOfAllTeachers() {
		return this.teacherRepository.findAll();
	}
	
	public Teacher saveTeacher( Teacher teacher ) {
		return this.teacherRepository.save( teacher );
	}

	@Override
	public Teacher getTeacherById(Long id) {
		return this.teacherRepository.findById( id ).get();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		return this.teacherRepository.save( teacher );
	}
	
	@Override
	public void removeTeacher( Long id ) {
		this.teacherRepository.deleteById( id );
	}
	
}
