package musala.schoolapp.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import musala.schoolapp.daoImpl.SchoolDaoImpl;
import musala.schoolapp.daoImpl.StudentDaoImpl;
import musala.schoolapp.daoImpl.SubjectDaoImpl;
import musala.schoolapp.model.School;
import musala.schoolapp.model.Student;
import musala.schoolapp.model.Subject;

public class SchoolApp {

	public static void main(String[] args) throws ParseException {

		List<Student> studentsfinki = new ArrayList<Student>();
		List<Student> studentsfeit = new ArrayList<Student>();

		School school1 = new School("FINKI", "Rugjer Boshkovikj, Skopje 1000, Macedonia", "+389 2 309 9191");
		School school2 = new School("FEIT", "Rugjer Boshkovikj, Skopje 1000, Macedonia", "+389 2 308 8292");

		Student student1 = new Student("Aleksandra", "Petkova", "female", getDate("05-06-1994"), "+398 78 292 616",
				"Kocani", "135002");
		Student student2 = new Student("Ivan", "Pavlov", "male", getDate("19-01-1995"), "+398 78 263 852", "Kocani",
				"135016");
		Student student3 = new Student("Gjurgjica", "Minova", "female", getDate("01-06-1994"), "+398 78 292 292",
				"Negotino", "124002");
		Student student4 = new Student("Emilija", "Nacova", "female", getDate("26-04-1994"), "+398 78 123 456",
				"Kocani", "1111");
		Student student5 = new Student("Hristina", "Jordanova", "female", getDate("12-06-1994"), "+398 78 456 123",
				"Kocani", "2222");

		Subject subject1 = new Subject("Strikturirano programiranje", "Zadolzitelen", 6);
		Subject subject2 = new Subject("Objektno-Orientirano programiranje", "Zadolzitelen", 6);
		Subject subject3 = new Subject("Bazi na podatoci", "Zadolzitelen", 6);
		Subject subject4 = new Subject("Napredni bazi na podatoci", "Izboren", 6);
		Subject subject5 = new Subject("Polustrukturirani bazi na podatoci i XML", "Izboren", 6);
		Subject subject6 = new Subject("Veb bazirnai sistemi", "Izboren", 6);
		Subject subject7 = new Subject("Diskrentna matematika 1", "Zadolzitelen", 6);
		Subject subject8 = new Subject("Diskrenta matematika 2", "Zadolzitelen", 6);
		Subject subject9 = new Subject("Algoritmi i podatocni strukturi", "Zadolzitelen", 6);
		Subject subject10 = new Subject("Operativni sistemi", "Zadolzitelen", 6);

		studentsfinki.add(student1);
		studentsfinki.add(student2);
		studentsfinki.add(student3);
		studentsfeit.add(student4);
		studentsfeit.add(student5);

		student1.setSchool(school1);
		student2.setSchool(school1);
		student3.setSchool(school1);
		student4.setSchool(school2);
		student5.setSchool(school2);
		school1.setStudents(studentsfinki);
		school2.setStudents(studentsfeit);

		List<Subject> subjectlist1 = new ArrayList<Subject>();
		subjectlist1.add(subject1);
		subjectlist1.add(subject2);
		student1.setSubjects(subjectlist1);

		List<Subject> subjectlist2 = new ArrayList<Subject>();
		subjectlist2.add(subject3);
		subjectlist2.add(subject4);
		student2.setSubjects(subjectlist2);

		List<Subject> subjectlist3 = new ArrayList<Subject>();
		subjectlist3.add(subject5);
		subjectlist3.add(subject6);
		student3.setSubjects(subjectlist3);

		List<Subject> subjectlist4 = new ArrayList<Subject>();
		subjectlist4.add(subject7);
		subjectlist4.add(subject8);
		student4.setSubjects(subjectlist4);

		List<Subject> subjectlist5 = new ArrayList<Subject>();
		subjectlist5.add(subject9);
		subjectlist5.add(subject10);
		student5.setSubjects(subjectlist5);

		List<Student> studentlist1 = new ArrayList<Student>();
		List<Student> studentlist2 = new ArrayList<Student>();
		List<Student> studentlist3 = new ArrayList<Student>();
		List<Student> studentlist4 = new ArrayList<Student>();
		List<Student> studentlist5 = new ArrayList<Student>();
		List<Student> studentlist6 = new ArrayList<Student>();
		List<Student> studentlist7 = new ArrayList<Student>();
		List<Student> studentlist8 = new ArrayList<Student>();
		List<Student> studentlist9 = new ArrayList<Student>();
		List<Student> studentlist10 = new ArrayList<Student>();

		studentlist1.add(student1);
		studentlist2.add(student1);
		studentlist3.add(student2);
		studentlist4.add(student2);
		studentlist5.add(student3);
		studentlist6.add(student3);
		studentlist7.add(student4);
		studentlist8.add(student4);
		studentlist9.add(student5);
		studentlist10.add(student5);

		subject1.setStudents(studentlist1);
		subject2.setStudents(studentlist2);
		subject3.setStudents(studentlist3);
		subject4.setStudents(studentlist4);
		subject5.setStudents(studentlist5);
		subject6.setStudents(studentlist6);
		subject7.setStudents(studentlist7);
		subject8.setStudents(studentlist8);
		subject9.setStudents(studentlist9);
		subject10.setStudents(studentlist10);

		SchoolDaoImpl schoolDaoImpl = new SchoolDaoImpl();
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		SubjectDaoImpl subjectDaoImpl = new SubjectDaoImpl();

		schoolDaoImpl.addSchool(school1);
		schoolDaoImpl.addSchool(school2);

		// list the schools
		System.out.println("\nList all the schools: ");
		List<School> schools = schoolDaoImpl.listSchools();
		for (School s : schools) {
			System.out.println(s.toString());
		}

		// list the students
		System.out.println("\nList all the students: ");
		List<Student> students = studentDaoImpl.listStudents();
		for (Student s : students) {
			System.out.println(s.toString());
		}

		// list the students that study in FINKI
		System.out.println("\nList the students that study in FINKI: ");
		List<Student> studentsBySchool1 = studentDaoImpl.listStudentsBySchool(school1);
		for (Student s : studentsBySchool1) {
			System.out.println(s.toString());
		}

		// list the students that study SP
		System.out.println("\nList the students that study SP: ");
		List<Student> studentsBySubject1 = studentDaoImpl.listStudentsBySubject(subject1);
		for (Student s : studentsBySubject1) {
			System.out.println(s.toString());
		}

		// list the subjects
		System.out.println("\nList all the subjects: ");
		List<Subject> subjects = subjectDaoImpl.listSubjects();
		for (Subject s : subjects) {
			System.out.println(s.toString());
		}

		// list the subjects that are studied by a given student
		System.out.println("\nList all the subjects that are studied by Aleksandra: ");
		List<Subject> subjectsByStudent1 = subjectDaoImpl.listSubjectsByStudent(student1);
		for (Subject s : subjectsByStudent1) {
			System.out.println(s.toString());
		}

	}

	private static Date getDate(String string) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date c = sdf.parse(string);
		return c;
	}

}
