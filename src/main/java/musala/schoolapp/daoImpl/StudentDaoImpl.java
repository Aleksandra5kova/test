package musala.schoolapp.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import musala.schoolapp.dao.StudentDao;
import musala.schoolapp.main.DBSessionFactory;
import musala.schoolapp.model.School;
import musala.schoolapp.model.Student;
import musala.schoolapp.model.Subject;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction tx = null;

	/* Method to ADD a student to the records */
	public void addStudent(Student student) {
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			System.out.println("Student added.");
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Student is not added.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Student is not added.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE a student from the records */
	public void deleteStudent(Integer id) {
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, id);
			session.delete(student);
			tx.commit();
			System.out.println("Student deleted.");
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Student is not deleted.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Student is not deleted.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to FIND student by id */
	public Student findById(Integer id) {
		Student student = null;
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, id);
			tx.commit();
			System.out.println("Returned " + student.toString());
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("Student is not found.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Student is not found.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	/* Method to LIST all the students */
	public List<Student> listStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM Student";
			Query query = session.createQuery(hql);
			students = query.list();
			tx.commit();
		} catch (HibernateException ex){
			if (tx != null){
				tx.rollback();
			}
			System.out.println("Students are not listed.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Students are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}

	@SuppressWarnings("unchecked")
	/* Method to LIST all the students that study in given school*/
	public List<Student> listStudentsBySchool(School school) {
		List<Student> students = new ArrayList<Student>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "FROM Student student WHERE student.school=:school";
			Query query = session.createQuery(hql);
			query.setParameter("school", school);
			students = query.list();
			tx.commit();
		} catch (HibernateException ex){
			if (tx != null){
				tx.rollback();
			}
			System.out.println("Students are not listed.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Students are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}
	
	@SuppressWarnings("unchecked")
	/* Method to LIST all the students that study a given subject*/
	public List<Student> listStudentsBySubject(Subject subject) {
		List<Student> students = new ArrayList<Student>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "SELECT student FROM Student student JOIN student.subjects subject where subject.id=:subjectId";
			Query query = session.createQuery(hql);
			query.setParameter("subjectId", subject.getId());
			students = query.list();
			tx.commit();
		} catch (HibernateException ex){
			if (tx != null){
				tx.rollback();
			}
			System.out.println("Students are not listed.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Students are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return students;
	}

}
