package com.qa.starterproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.starterproject.domain.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	@Query(value = "SELECT * FROM STUDENT where surname = ?1", nativeQuery = true)
	public List<Student> findBySurname(String str);
	
}
