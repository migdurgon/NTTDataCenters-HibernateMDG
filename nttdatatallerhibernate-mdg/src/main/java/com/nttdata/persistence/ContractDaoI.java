/**
 * 
 */
package com.nttdata.persistence;

import java.util.List;

/**
 * @author Miguel Durán
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Obtiene contratos por identificador de cliente.
	 * 
	 * @param clientId
	 * @return List<Contract>
	 */
	public List<Contract> findByClientId(final Long clientId);
}
