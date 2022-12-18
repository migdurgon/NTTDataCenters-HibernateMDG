package com.nttdata.persistence;

import java.util.Date;
import java.util.List;

/**
 * DAO de tabla T_CLIENTE
 * 
 * @author Miguel Durán
 *
 */
public interface ClientDaoI extends CommonDaoI<Client> {

	/**
	 * Obtiene clientes por nombre y apellidos.
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return List<Cliente>
	 */
	public List<Client> findByNameAndSurnameAndSecondSurname(final String name, final String surname, final String secondSurname);
	
	/**
	 * Obtiene clientes por nombre.
	 * 
	 * @param name
	 * @return List<Cliente>
	 */
	public List<Client> findByName(final String name);

	/**
	 * Obtiene clientes por nombre y precio mensual de contrato.
	 * 
	 * @param name
	 * @param monthlyPrice
	 * @return List<Cliente>
	 */
	public List<Client> searchByNameAndMonthlyPriceContract(final String name,final Double monthlyPrice);

	/**
	 * Obtiene clientes por nombre y precio mensual de contrato.
	 * 
	 * @param name
	 * @param expiryDate
	 * @return List<Cliente>
	 */
	public List<Client> searchByNameAndExpireDateContract(final String name,final Date expiryDate);

}
