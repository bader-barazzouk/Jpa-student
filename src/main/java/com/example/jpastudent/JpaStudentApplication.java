package com.example.jpastudent;

import com.example.jpastudent.entities.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaStudentApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaStudentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        for (int i = 0; i<100 ; i++) {
            studentRepository.save(
                    new Student(null,"Bader","Barazzouk","baderbarazzouk@gmail.com",new Date(),"MASCULIN",Math.random()>0.5?true:false));
        }

        Page<Student> students = studentRepository.findAll(PageRequest.of(0,10));
        System.out.println("Total pages:"+students.getTotalPages());
        System.out.println("Total elements:"+students.getTotalElements());
        System.out.println("Num Page:"+students.getNumber());
        List<Student> content = students.getContent();
        Page<Student> byRegle = studentRepository.findByRegle(true, PageRequest.of(0,4));
        students.getContent();
        byRegle.forEach(p->{
            System.out.println("*****************************************************");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getPrenom());
            System.out.println(p.getEmail());
            System.out.println(p.getDateNaissance());
            System.out.println(p.getGenre());
            System.out.println(p.isRegle());

        });
        System.out.println("///////////////////////////////////////////////");
        Student student=studentRepository.findById(1L).orElse(null);
        if(student!=null){
            System.out.println(student.getNom());
            System.out.println(student.isRegle());

        }
        studentRepository.save(student);
        studentRepository.deleteById(1L);

    }

}


