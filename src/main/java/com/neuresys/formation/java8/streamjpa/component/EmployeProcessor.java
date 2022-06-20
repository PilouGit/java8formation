package com.neuresys.formation.java8.streamjpa.component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.neuresys.formation.java8.streamjpa.model.Employe;
import com.neuresys.formation.java8.streamjpa.repository.EmployeRepository;


@Component
public class EmployeProcessor {
  
  private final EmployeRepository bookRepository;
  private EntityManager entityManager;
  
  public EmployeProcessor(EmployeRepository bookRepository, EntityManager entityManager) {
    this.bookRepository = bookRepository;
    this.entityManager = entityManager;
  }
  
  
  @Transactional(readOnly = true)
  public List<Employe> processEmploye2(String email) {
    Stream<Employe> employeStream = bookRepository.getAll();
    return employeStream.
    filter(e->e.getEmail().equalsIgnoreCase(email))
    .collect(Collectors.toList());
    
  }
  
  
  @Transactional(readOnly = true)
  public List<Employe> processEmploye(String email) {
    Stream<Employe> employeStream = bookRepository.getAll();
    return
    employeStream .filter(employe -> {
    boolean result= employe.getEmail().contains(email);
    entityManager.detach(employe);
    return result;
    }
    )    
    .collect(Collectors.toList());      
    
  }


public List<Employe> findAllEmploye() {
	// TODO Auto-generated method stub
	return null;
}
}
