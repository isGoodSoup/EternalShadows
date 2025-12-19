package es.eternalshadow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.eternalshadow.dao.interfaces.UsuarioDAO;
import es.eternalshadow.entities.Usuario;
import es.eternalshadow.util.HibernateUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void guardar(Object usuario) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory()) {
			tx = session.beginTransaction();
			session.persist(usuario);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}
	
	@Override
	public void eliminar(Long id) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory()) {
			tx = session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			if (usuario != null) {
				session.remove(usuario);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public void actualizar(Object usuario) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory()) {
			tx = session.beginTransaction();
			session.merge(usuario);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		try (Session session = HibernateUtil.getSessionFactory()) {
			return session.get(Usuario.class, id);
		}
	}

	@Override
	public List<Usuario> obtenerTodasLosUsuario() {
		try (Session session = HibernateUtil.getSessionFactory()) {
			return session.createQuery("from Usuario", Usuario.class).list();
		}
	}
}
