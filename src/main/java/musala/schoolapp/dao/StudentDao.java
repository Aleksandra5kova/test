package musala.schoolapp.dao;

import java.util.List;

import musala.schoolapp.model.School;
import musala.schoolapp.model.Student;
import musala.schoolapp.model.StudentDTO;
import musala.schoolapp.model.Subject;

public interface StudentDao {

	public void addStudent(Student student);
	
	public void deleteStudent(Integer id);
	
	public Student findById(Integer id);
	
	public List<Student> listStudents();
	
	public List<Student> listStudentsBySchool(School school);
	
	public List<Student> listStudentsBySubject(Subject subject);
	
	public List<Student> countGirls();
	
	public List<StudentDTO> listGirls();
}
