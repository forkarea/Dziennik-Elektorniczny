package pl.polsl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.polsl.dao.SubjectDao;
import pl.polsl.domain.Subject;
import pl.polsl.service.GetSubject;

@Service
public class GetSubjectImpl implements GetSubject {

	@Autowired
	SubjectDao subjectDao;

	@Override
	public List<Subject> getSubject() {
		List<Subject> subjects = new ArrayList<Subject>();
		Iterable<Subject> subjectsFromDatabase = subjectDao.findAll();
		for (Subject item : subjectsFromDatabase) {
			subjects.add(item);
		}
		return subjects;
	}

}
