package net.java.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.java.sms.repository.StudentRepository;
import net.java.sms.entity.Student;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run( String... args ) throws Exception {

//		Student student1 = new Student( "Satheesh", "Sm", "smsatheesh2000@gmail.com" );
//		studentRepository.save( student1 );
//		
//		Student student2 = new Student( "Harish", "Sm", "smharish2001@gmail.com" );
//		studentRepository.save( student2 );
//		
//		Student student3 = new Student( "Santhosh", "M", "sathoshsmart@gmail.com" );
//		studentRepository.save( student3 );
	}
	
}
