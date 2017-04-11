package musala.schoolapp.dao;
import java.util.List;

import musala.schoolapp.model.School;
import musala.schoolapp.model.Student;

public interface SchoolDao {

	public void addSchool(School school);
	
	public void deleteSchool(Integer id);
	
	public void updateSchoolName(Integer id, String name);
	
	public School findById(Integer id);
	
	public List<School> listSchools();
	
	public String schoolNameByStudent(Student student);
	
	public List<School> schoolNameByStudent1(Student student);
	
	public List<School> listSchoolsWithStudents();
}
