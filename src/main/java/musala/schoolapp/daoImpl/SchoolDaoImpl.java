package musala.schoolapp.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import musala.schoolapp.dao.SchoolDao;
import musala.schoolapp.main.DBSessionFactory;
import musala.schoolapp.model.School;
import musala.schoolapp.model.Student;

public class SchoolDaoImpl implements SchoolDao {

	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction tx = null;

	/* Method to ADD a school to the records */
	public void addSchool(School school) {
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(school);
			tx.commit();
			System.out.println("School added.");
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("School is not added.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to DELETE a school from the records */
	public void deleteSchool(Integer id) {
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			School school = (School) session.get(School.class, id);
			session.delete(school);
			tx.commit();
			System.out.println("School deleted.");
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("School is not deleted.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to UPDATE the name of a particular school */
	public void updateSchoolName(Integer id, String name) {
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			School school = (School) session.get(School.class, id);
			school.setName(name);
			session.update(school);
			tx.commit();
			System.out.println("School updated.");
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("School is not updated.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to FIND school by id */
	public School findById(Integer id) {
		School school = null;
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			school = (School) session.get(School.class, id);
			tx.commit();
			System.out.println("Returned " + school.toString());
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("School is not found.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return school;
	}

	@SuppressWarnings("unchecked")
	/* Method to LIST all the schools */
	public List<School> listSchools() {
		List<School> schools = new ArrayList<School>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.getNamedQuery("school.listSchools");
			schools = query.list();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Schools are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return schools;
	}

	/* Method to RETURN school's name for given student */
	@SuppressWarnings("unchecked")
	public String schoolNameByStudent(Student student) {
		String schoolName = "";
		List<School> schools = new ArrayList<School>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(School.class);
			cr.createAlias("students", "student", JoinType.INNER_JOIN);
			cr.add(Restrictions.eq("student.id", student.getId()));
			schools = cr.list();
			schoolName = (schools.get(0) != null ? schools.get(0).getName() : "");
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Schools are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return schoolName;
	}

	/* Method to RETURN school's name for given student */
	@SuppressWarnings("unchecked")
	public List<School> schoolNameByStudent1(Student student) {
		List<School> schools = new ArrayList<School>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(School.class);
			cr.setProjection(Projections.property("name"));
			cr.createAlias("students", "student", JoinType.INNER_JOIN);
			cr.add(Restrictions.eq("student.id", student.getId()));
			schools = cr.list();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Schools are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return schools;
	}

	@SuppressWarnings("unchecked")
	/* Method to LIST all the schools with the students */
	public List<School> listSchoolsWithStudents() {
		List<School> schools = new ArrayList<School>();
		try {
			sessionFactory = DBSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("school.listSchoolsWithStudents");
			schools = query.list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Schools are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return schools;
	}

}
