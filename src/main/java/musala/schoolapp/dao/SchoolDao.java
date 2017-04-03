package musala.schoolapp.dao;
import java.util.List;

import musala.schoolapp.model.School;

public interface SchoolDao {

	public void addSchool(School school);
	
	public void deleteSchool(Integer id);
	
	public void updateSchoolName(Integer id, String name);
	
	public School findById(Integer id);
	
	public List<School> listSchools();
	
}
