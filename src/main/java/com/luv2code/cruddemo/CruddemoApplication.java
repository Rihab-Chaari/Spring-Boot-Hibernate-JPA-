package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
				//createStudent(studentDAO);

				//createMultipleStudents(studentDAO);

				//readStudent(studentDAO);

				//queryForStudents(studentDAO);

				//queryForStudentsByLastName(studentDAO);

				//updateStudent(studentDAO);

				//deleteStudent(studentDAO);

				//deleteAllStudents(studentDAO);


		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting  all students ");
		int numRow = studentDAO.deleteAll();
		System.out.println("Deleted row count :"+numRow);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=5;
		System.out.println("Deleting student  id:"+studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id:"+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "rihab"
		System.out.println("Updating student...");
		myStudent.setFirstName("Rihab");
		//update the student
		studentDAO.update(myStudent);
		//display the update student
		System.out.println("Updated student "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("chaaben");

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("creating student object...");
		Student tempStudent = new Student("ryry","chaaben","ryry.chaaben@gmail.com");
		// save the student
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Genereted:"+theId);

		// retrieve student based on the id: primary key
		System.out.println("retrieving student with id:"+theId);
		Student myStudent = studentDAO.findById(theId);
		// display student
		System.out.println("found the student :"+myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("creating 3 student objects ...");
		Student tempStudent1= new Student("Ali","chaaben","ali.chaaben@gmail.com");
		Student tempStudent2= new Student("farah","benhenda","farah.benhenda@gmail.com");
		Student tempStudent3= new Student("yosra","hammoudi","yosra.hammoudi@gmail.com");
		//save the student objects
		System.out.println("saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("creating student object ...");
		Student tempStudent= new Student("Rihab","chaari","rihab.chaari@gmail.com");

		//save the student object
		System.out.println("saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved stusent
		System.out.println("saved student. Generated id:"+tempStudent.getId());
	}
}
