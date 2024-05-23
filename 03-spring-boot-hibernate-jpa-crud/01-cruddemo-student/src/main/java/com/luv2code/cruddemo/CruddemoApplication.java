package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//Create a new student
			//createStudent(studentDAO);

			//Create multiple students
			createMultipleStudent(studentDAO);

			//Read a student
			//readStudent(studentDAO);

			//readAllStudent(studentDAO);

			//queryFromStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Rows Deleted: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;

		Student theStudent = studentDAO.findById(studentId);

		theStudent.setLastName("Quiterio");

		studentDAO.update(theStudent);

		System.out.println(theStudent);

	}

	private void queryFromStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Reyes");

		for (Student student : theStudents){
			System.out.println(student.toString());
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for (Student student : theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		Student student = new Student("Eliceo", "Reyes", "eliseoreyesq@gmail.com");
		//save the student
		studentDAO.save(student);
		//display id of the saved student
		System.out.printf("The student id saved is %d%n", student.getId());
		//retrieve student base on the id: primary key
		Student newStudent = studentDAO.findById(student.getId());
		//display student
		System.out.println(newStudent.toString());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//Create multiple student
		System.out.println("Creating new student list...");
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("David", "Reyes", "davidreyes@gmail.com"));
		studentList.add(new Student("Saul", "Reyes", "saulreyes@gmail.com"));
		studentList.add(new Student("Andres", "Reyes", "andresreyes@gmail.com"));

		//save the student object

		System.out.println("Saving the students");
		for (Student student : studentList){
			studentDAO.save(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Eliceo", "Reyes", "elreyesq17@gmail.com");
		//save de student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.printf("Saved student. Generated id: %d%n", tempStudent.getId());
	}
}
