package com.sazzadcode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {

        return this.studentRepository.findAll();

    }

    public void addStudent(Student student)
    {
        System.out.println(student);
        this.studentRepository.save(student);

    }
    public void deleteStudent(Long id)
    {
       Optional<Student> exists= this.studentRepository.findById(id);
       if (!exists.isPresent())
       {
           throw new IllegalStateException("student does not exists");
       }
       this.studentRepository.deleteById(id);



    }

}
