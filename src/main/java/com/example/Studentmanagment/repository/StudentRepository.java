package com.example.Studentmanagment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Studentmanagment.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
