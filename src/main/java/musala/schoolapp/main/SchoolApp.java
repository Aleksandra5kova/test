package musala.schoolapp.main;

import java.text.ParseException;

import musala.schoolapp.daoImpl.SchoolDaoImpl;
import musala.schoolapp.daoImpl.StudentDaoImpl;
import musala.schoolapp.daoImpl.SubjectDaoImpl;


public class SchoolApp {

	public static void main(String[] args) throws ParseException {

//		LoadData.loadData();

		SchoolDaoImpl schoolDaoImpl = new SchoolDaoImpl();
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		
		// list the schools
		System.out.println("\nList all the schools: ");
		System.out.println(schoolDaoImpl.listSchools());

		// list the school where Aleksandra study
		System.out.println("\nAleksandra study in the school: ");
		System.out.println(schoolDaoImpl.schoolNameByStudent(studentDaoImpl.findById(1)));
		System.out.println("\nAleksandra study in the school: ");
		System.out.println(schoolDaoImpl.schoolNameByStudent1(studentDaoImpl.findById(1)));

		// list the students
		System.out.println("\nList all the students: ");
		System.out.println(studentDaoImpl.listStudents());

		// list the students that study in FINKI
		System.out.println("\nList the students that study in FINKI: ");
		System.out.println(studentDaoImpl.listStudentsBySchool(schoolDaoImpl.findById(1)));

		// list the students that study SP
		System.out.println("\nList the students that study SP: ");
		System.out.println(studentDaoImpl.listStudentsBySubject(subjectDaoImpl.findById(1)));

		// list the subjects
		System.out.println("\nList all the subjects: ");
		System.out.println(subjectDaoImpl.listSubjects());

		// list the subjects that are studied by a given student
		System.out.println("\nList all the subjects that are studied by Aleksandra: ");
		System.out.println(subjectDaoImpl.listSubjectsByStudent(studentDaoImpl.findById(1)));

		// count the girls which index starts with 135
		System.out.println("\nNumber of girls which index starts with 135:");
		System.out.println(studentDaoImpl.countGirls());

		// list the girls which index starts with 135
//		System.out.println("\nList of girls which index starts with 135:");
//		List<Student> girls = studentDaoImpl.listGirls();
//		@SuppressWarnings("rawtypes")
//		Iterator it = girls.iterator();
//		while (it.hasNext()) {
//			Object[] obj = (Object[]) it.next();
//			System.out.println("Student[id=" + obj[0] + ", firstname=" + obj[1] + ", lastname=" + obj[2] + "]");
//		}
//		for(Student girl : girls) {
//			System.out.println(girl.toString());
//		}
		
		
	}


}
