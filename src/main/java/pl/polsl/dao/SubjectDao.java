package pl.polsl.dao;

import org.springframework.data.repository.CrudRepository;

import pl.polsl.domain.Subject;

public interface SubjectDao  extends CrudRepository<Subject, Long>{

	Iterable<Subject> findAll();
	
	Subject findBySubjectName(String subjectName);
	
}
