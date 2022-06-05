package com.example.jpastudent.repositories;

import com.example.jpastudent.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByRegle (boolean r);
    Page<Student> findByRegle (boolean r, Pageable pageable);


}
