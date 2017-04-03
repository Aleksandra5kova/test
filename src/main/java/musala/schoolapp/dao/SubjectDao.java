package musala.schoolapp.dao;

import java.util.List;

import musala.schoolapp.model.Student;
import musala.schoolapp.model.Subject;

public interface SubjectDao {
	
	public void addSubject(Subject subject);
	
	public void deleteSubject(Integer id);
	
	public void updateCredits(Integer id, Integer credits);
	
	public void updateStatus(Integer id, String status);
	
	public Subject findById(Integer id);
	
	public List<Subject> listSubjects();
	
	public List<Subject> listSubjectsByStudent(Student student);

}
