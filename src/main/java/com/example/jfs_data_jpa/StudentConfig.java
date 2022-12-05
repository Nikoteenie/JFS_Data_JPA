package com.example.jfs_data_jpa;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;


@Configuration
public class StudentConfig {
    private static final Logger log = LoggerFactory.getLogger(JfsDataJpaApplication.class);
//    @Autowired
    private StudentService studentService;

    public StudentConfig(StudentService studentService){
        this.studentService = studentService;
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return (args) -> {
            // save a few Students
          repository.save(new Student( "Bauer"));
           repository.save(new Student( "O'Brian"));
       repository.save(new Student( "Kennedy"));
         repository.save(new Student( "Palmer"));
           repository.save(new Student( "Dessler"));

            // fetch students using method from StudentService.java
            log.info("Students found with method from StudentService");
            log.info("----------------------------------------------");
            studentService.getStudents().forEach(studentOne -> {
                log.info(studentOne.toString());
            });
            log.info("");

            // fetch an individual student by ID
            log.info("Student found with findById(1L):");
            log.info("--------------------------------");
            log.info(studentService.findOne(1L).toString());
            log.info("");

            // fetch Students by last name
            log.info("Student found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            studentService.findByName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");

            // add Student using addStudent() method from StudentService
            studentService.addStudent(new Student("New Student"));
            log.info("Added one Student here");
            log.info("");


// fetch students using method from StudentService.java
            log.info("Check to see if Student has been added");
            log.info("----------------------------------------------");
            studentService.getStudents().forEach(studentOne -> {
                log.info(studentOne.toString());
            });
            log.info("");

            // delete student with id 3
            log.info("Delete Student with id of 3");
            log.info("---------------------------");
            studentService.deleteStudent(3L);
            log.info("");

            // fetch students again to see if Student with id was deleted
            log.info("See if Student with id of 3 has been deleted");
            log.info("----------------------------------------------");
            studentService.getStudents().forEach(studentOne -> {
                log.info(studentOne.toString());
            });

        };
    }

}
