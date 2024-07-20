package net.java.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.sms.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
