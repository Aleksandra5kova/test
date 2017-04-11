package musala.schoolapp.main;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import musala.schoolapp.dao.SchoolDao;
import musala.schoolapp.dao.StudentDao;
import musala.schoolapp.dao.SubjectDao;
import musala.schoolapp.daoImpl.SchoolDaoImpl;
import musala.schoolapp.daoImpl.StudentDaoImpl;
import musala.schoolapp.daoImpl.SubjectDaoImpl;
import musala.schoolapp.model.School;
import musala.schoolapp.model.Student;
import musala.schoolapp.model.StudentDTO;

public class SchoolApp {

	public static void main(String[] args) throws ParseException {

		// LoadData.loadData();

		SchoolDao schoolDao = new SchoolDaoImpl();
		SubjectDao subjectDao = new SubjectDaoImpl();
		StudentDao studentDao = new StudentDaoImpl();

		// list the schools
		System.out.println("\nList all the schools: ");
		System.out.println(schoolDao.listSchools());

		// list the school where Aleksandra study
		System.out.println("\nAleksandra study in the school: ");
		System.out.println(schoolDao.schoolNameByStudent(studentDao.findById(1)));
		System.out.println("\nAleksandra study in the school: ");
		System.out.println(schoolDao.schoolNameByStudent1(studentDao.findById(1)));

		// list the students
		System.out.println("\nList all the students: ");
		System.out.println(studentDao.listStudents());

		// list the students that study in FINKI
		System.out.println("\nList the students that study in FINKI: ");
		System.out.println(studentDao.listStudentsBySchool(schoolDao.findById(1)));

		// list the students that study SP
		System.out.println("\nList the students that study SP: ");
		System.out.println(studentDao.listStudentsBySubject(subjectDao.findById(1)));

		// list the subjects
		System.out.println("\nList all the subjects: ");
		System.out.println(subjectDao.listSubjects());

		// list the subjects that are studied by a given student
		System.out.println("\nList all the subjects that are studied by Aleksandra: ");
		System.out.println(subjectDao.listSubjectsByStudent(studentDao.findById(1)));

		// count the girls which index starts with 135
		System.out.println("\nNumber of girls which index starts with 135:");
		System.out.println(studentDao.countGirls());

		// list the girls which index starts with 135
		System.out.println("\nList of girls which index starts with 135:");
		List<StudentDTO> girls = studentDao.listGirls();
		for (StudentDTO girl : girls) {
			System.out.println(girl.toString());
		}

		/* list all the schools with the students */
		System.out.println("\nList all the schools with the students: ");
		List<School> schoolWithStudents = schoolDao.listSchoolsWithStudents();
		for (School s : schoolWithStudents) {
			System.out.println(s.toString());
			for (Student st : s.getStudents()) {
				System.out.println(st.toString());
			}
		}
	}

}
