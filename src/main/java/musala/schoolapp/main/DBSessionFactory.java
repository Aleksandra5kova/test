package musala.schoolapp.main;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

public class DBSessionFactory {

	private static SessionFactory sessionFactory;

	/* Method to create SessionFactory */
	private static void createSessionFactory() {
		try {
			if (sessionFactory == null) {

				Properties properties = new Properties();
				properties.load(ClassLoader.getSystemResourceAsStream("hibernate.properties"));

				Configuration configuration = new Configuration();
				EntityScanner.scanPackages("musala.schoolapp.model").addTo(configuration);
				configuration.mergeProperties(properties).configure();
				StandardServiceRegistry builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(builder);
			}
		} catch (Exception ex) {
			System.out.println("Failed to create session factory object.");
			ex.printStackTrace();
		}
	}

	/* Method to return SessionFactory */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			createSessionFactory();
		}
		return sessionFactory;
	}
}
