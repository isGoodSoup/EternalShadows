package es.eternalshadow.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import es.eternalshadow.entities.Usuario;

public class HibernateUtil {
	private static Session session;

	private static Session getSession() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}

	public static Session getSessionFactory() {
		if (session == null || !session.isOpen()) {
			session = getSession();
		}
		return session;
	}

	public static void ComprobarRolAdmin() {
		session = getSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			String hql = "FROM Usuario u WHERE u.rol = :rol";
			Usuario admin = session.createQuery(hql, Usuario.class).setParameter("rol", "ADMIN").setMaxResults(1)
					.uniqueResult();

			if (admin == null) {
				Usuario nuevoAdmin = new Usuario();
				nuevoAdmin.setUsername("admin");
				nuevoAdmin.setPassword("password");
				nuevoAdmin.setRol("ADMIN");
				session.persist(nuevoAdmin);
				System.out.println("Usuario ADMIN creado con éxito.");
			} else {
				System.out.println("Ya existe un usuario ADMIN.");
			}
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
