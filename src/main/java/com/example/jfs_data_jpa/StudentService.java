package com.example.jfs_data_jpa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findOne(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public List<Student> findByName(String studentName) {
        return studentRepository.findByName(studentName);
    }


    public void addStudent(Student student){
     studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }



}
