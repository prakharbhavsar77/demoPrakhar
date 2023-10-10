package com.example.prakhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prakhar.entity.BioData;

@Repository
public interface biodatarepo extends JpaRepository<BioData, Integer>{

}
