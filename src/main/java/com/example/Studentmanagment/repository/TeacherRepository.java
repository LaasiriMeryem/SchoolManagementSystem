package com.example.Studentmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Studentmanagment.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
