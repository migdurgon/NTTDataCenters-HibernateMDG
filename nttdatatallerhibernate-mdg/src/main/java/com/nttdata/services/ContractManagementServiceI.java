/**
 * 
 */
package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Contract;

/**
 * Interface del servicio de contratos.
 * 
 * @author Miguel Durán
 *
 */
public interface ContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

	/**
	 * Obtiene un contrato por su nombre.
	 * 
	 * @param name
	 * @return List<Contract>
	 */
	public List<Contract> searchByClientId(final Long clientId);
}
