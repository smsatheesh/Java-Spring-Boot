package net.java.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	
}
