package es.eternalshadow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.eternalshadow.dao.interfaces.UsuarioDAO;
import es.eternalshadow.entities.Usuario;
import es.eternalshadow.util.HibernateUtil;

public class UsuarioDAOImpl implements UsuarioDAO {
	private Session session;
	private Transaction transaction;
	
	public UsuarioDAOImpl() {
		super();
		session = HibernateUtil.getSessionFactory();
		transaction = session.beginTransaction();
	}

	@Override
	public void guardar(Object obj) {
		session.persist(obj);
	}

	@Override
	public void eliminar(Long id) {
		Usuario usuario = obtenerPorId(id);
		if (usuario != null) {
			session.remove(usuario);
			transaction.commit();
		}
	}

	@Override
	public void actualizar(Object obj) {
		session.merge(obj);
		transaction.commit();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return session.get(Usuario.class, id);
	}

	@Override
	public List<Usuario> obtenerTodasLosUsuario() {
		return session.createQuery("from TB_USUARIO", Usuario.class).list();
	}
}
