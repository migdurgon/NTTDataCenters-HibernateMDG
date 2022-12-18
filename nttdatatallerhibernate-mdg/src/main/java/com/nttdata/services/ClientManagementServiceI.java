package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Client;

/**
 * Interface del servicio de clientes.
 * 
 * @author Miguel Durán
 *
 */
public interface ClientManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param clientId
	 */
	public Client searchById(final Long clientId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();
	
	/**
	 * Obtiene un cliente por su nombre.
	 * 
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> searchByName(final String name);
	
	/**
	 * Obtiene un cliente por su nombre y apellidos.
	 * 
	 * @param names
	 * @param surname
	 * @param secondSurname
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndSurnameAndSecondSurname(final String name, final String surname, final String secondSurname);


}
