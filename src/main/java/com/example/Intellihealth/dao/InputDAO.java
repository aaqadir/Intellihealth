package com.example.Intellihealth.dao;

import com.example.Intellihealth.model.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputDAO extends JpaRepository<Input, Integer>{

}
