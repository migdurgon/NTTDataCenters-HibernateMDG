package com.nttdata.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Contract;

/**
 * DAO de tabla T_CLIENTE
 * 
 * @author Miguel Durán
 *
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public List<Client> findByNameAndSurnameAndSecondSurname(String name, String surname, String secondSurname) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre y apellidos.
		final List<Client> clientsList = 
				session.createQuery("FROM Client WHERE name=" + name + " AND surname=" + surname + " AND secondSurname=" + secondSurname).list();

		return clientsList;
	}

	@Override
	public List<Client> findByName(String name) {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre.
		final List<Client> clientsList = session.createQuery("FROM Client WHERE name=" + name).list();

		return clientsList;
	}
	
	@Override
	public List<Client> searchByNameAndMonthlyPriceContract(final String name, final Double monthlyPrice) {

		// Consulta.
		final CriteriaBuilder cb = (CriteriaBuilder) session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contract");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.getParent().<String> get("name"), name);
		final Predicate pr2 = cb.gt(pJoinT.<Double> get("monthlyPrice"), monthlyPrice);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		// Ordenación descendente (mayor a menor) de precio mensual.
		cquery.orderBy(cb.desc(pJoinT.get("monthlyPrice")));

		// Ejecución de consulta.
		final List<Client> results = session.createQuery(cquery).getResultList();

		return results;
	}
	
	@Override
	public List<Client> searchByNameAndExpireDateContract(final String name, final Date expiryDate) {

		// Consulta.
		final CriteriaBuilder cb = (CriteriaBuilder) session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contract");

		// Where.
		final Predicate pr1 = cb.like(pJoinT.getParent().<String> get("name"), name);
		final Predicate pr2 = cb.gt(pJoinT.<Date> get("expiryDate"), expiryDate);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1, pr2));

		// Ordenación descendente (mayor a menor) de fecha de expiración.
		cquery.orderBy(cb.desc(pJoinT.get("monthlyPrice")));

		// Ejecución de consulta.
		final List<Client> results = session.createQuery(cquery).getResultList();

		return results;
	}


}
