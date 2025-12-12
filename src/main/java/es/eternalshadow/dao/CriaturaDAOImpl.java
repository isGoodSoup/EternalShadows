package es.eternalshadow.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.eternalshadow.entities.Criatura;
import es.eternalshadow.util.HibernateUtil;

public class CriaturaDAOImpl implements CriaturaDAO {

	private Session session;
	private Transaction transaction;

	public CriaturaDAOImpl() {
		session = HibernateUtil.getSessionFactory();
		transaction = session.beginTransaction();
	}

	@Override
	public void guardarCriatura(Criatura criatura) {
		// TODO Auto-generated method stub
		session.persist(criatura);

	}

	@Override
	public void eliminarCriatura(Long id) {
		// TODO Auto-generated method stub
		Criatura criatura = obtenerCriaturaPorId(id);
		if (criatura != null) {
			session.remove(criatura);
			transaction.commit();
		}

	}

	@Override
	public void actualizarCriatura(Criatura criatura) {
		// TODO Auto-generated method stub
		session.merge(criatura);
		transaction.commit();

	}

	@Override
	public Criatura obtenerCriaturaPorId(Long id) {
		// TODO Auto-generated method stub
		return session.get(Criatura.class, id);
	}

	@Override
	public List<Criatura> obtenerTodasLasCriaturas() {
		// TODO Auto-generated method stub
		return session.createQuery("from Criatura", Criatura.class).list();
	}

}
