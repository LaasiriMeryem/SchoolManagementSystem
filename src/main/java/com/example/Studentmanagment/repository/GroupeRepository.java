package com.example.Studentmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Studentmanagment.entity.Groupe;
import com.example.Studentmanagment.entity.TypeGroupes;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe,TypeGroupes>{

}
