package musala.schoolapp.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import musala.schoolapp.dao.SchoolDao;
import musala.schoolapp.main.DBSessionFactory;
import musala.schoolapp.model.School;

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
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("School is not added.");
			ex.printStackTrace();
		} catch(Exception ex){
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
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println("School is not deleted.");
			ex.printStackTrace();
		} catch(Exception ex){
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
		} catch(HibernateException ex){
			if(tx != null){
				tx.rollback();
			}
			System.out.println("School is not updated.");
			ex.printStackTrace();
		} catch (Exception ex) {
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
		} catch (HibernateException ex){
			if (tx != null){
				tx.rollback();
			}
			System.out.println("School is not found.");
			ex.printStackTrace();
		} catch (Exception ex) {
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
			String hql = "FROM School";
			Query query = session.createQuery(hql);
			schools = query.list();
			tx.commit();
		} catch (HibernateException ex){
			if (tx != null){
				tx.rollback();
			}
			System.out.println("Schools are not listed.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Schools are not listed.");
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return schools;
	}

}
