package com.example.Intellihealth.dao;

import com.example.Intellihealth.model.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputDAO extends JpaRepository<Output, Integer>{
	
	
}
