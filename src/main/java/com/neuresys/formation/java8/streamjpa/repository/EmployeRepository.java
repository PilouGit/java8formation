package com.neuresys.formation.java8.streamjpa.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.QueryHints;
import javax.persistence.QueryHint;

import com.neuresys.formation.java8.streamjpa.model.Employe;

public interface EmployeRepository  extends Repository<Employe, Long> {
    
   
    @Query("select e from Employe e ")
	public
    Stream<Employe> getAll();
}
