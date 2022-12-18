package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.apache.commons.lang3.StringUtils;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.ClientDaoI;
import com.nttdata.persistence.ClientDaoImpl;

/**
 * Implementación del servicio de clientes.
 * 
 * @author Miguel Durán
 *
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/** DAO: T-CLIENTE */
	private ClientDaoI clientDao;

	/**
	 * Método constructor.
	 */
	public ClientManagementServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}

	public void insertNewClient(final Client newClient) {

		// Verificación de nulidad e inexistencia.
		if (newClient != null && newClient.getClientId() == null) {

			// Insercción del nuevo cliente.
			clientDao.insert(newClient);
		}

	}

	public void updateClient(final Client updatedClient) {

		// Verificación de nulidad y existencia.
		if (updatedClient != null && updatedClient.getClientId() != null) {

			// Actualización del cliente.
			clientDao.update(updatedClient);
		}

	}

	public void deleteClient(final Client deletedClient) {

		// Verificación de nulidad y existencia.
		if (deletedClient != null && deletedClient.getClientId() != null) {

			// Eliminación del cliente.
			clientDao.delete(deletedClient);
		}

	}

	public Client searchById(final Long clientId) {

		// Resultado.
		Client client = null;

		// Verificación de nulidad.
		if (clientId != null) {

			// Obtención del cliente por ID.
			client = clientDao.searchById(clientId);
		}

		return client;
	}

	@Override
	public List<Client> searchAll() {

		// Resultado.
		List<Client> clientsList = new ArrayList<>();

		// Obtención de clientes.
		clientsList = clientDao.searchAll();

		return clientsList;
	}

	public List<Client> searchByName(final String name) {

		// Resultado.
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención del cliente por nombre.
			clientsList = clientDao.findByName(name);
		}

		return clientsList;
	}

	public List<Client> searchByNameAndSurnameAndSecondSurname(final String name, final String surname, final String secondSurname) {

		// Resultado.
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {

			// Obtención del cliente por nombre y apellidos.
			clientsList = clientDao.findByNameAndSurnameAndSecondSurname(name, surname, secondSurname);
		}

		return clientsList;
	}

}
