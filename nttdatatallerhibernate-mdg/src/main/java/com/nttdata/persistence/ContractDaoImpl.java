/**
 * 
 */
package com.nttdata.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * @author Miguel Durán
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI{

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Contract> findByClientId(Long clientId) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza contratos en función del identificador de cliente.
		final List<Contract> contractsList = 
				session.createQuery("FROM Contract WHERE client=" + clientId).list();

		return contractsList;
	}
}
