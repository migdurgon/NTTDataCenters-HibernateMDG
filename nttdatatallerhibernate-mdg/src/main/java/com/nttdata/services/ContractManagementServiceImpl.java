/**
 * 
 */
package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.ContractDaoI;
import com.nttdata.persistence.ContractDaoImpl;
import com.nttdata.persistence.Contract;

/**
 * Implementación del servicio de contratos.
 * 
 * @author Miguel Durán
 *
 */
public class ContractManagementServiceImpl implements ContractManagementServiceI {

	/** DAO: T-CONTRACT */
	private ContractDaoI contractDao;

	/**
	 * Método constructor.
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract newContract) {
		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getContractId() == null) {
			// Insercción del nuevo contrato.
			contractDao.insert(newContract);
		}
	}

	@Override
	public void updateContract(Contract updatedContract) {
		// Verificación de nulidad y existencia.
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Actualización del contrato.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(Contract deletedContract) {
		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Eliminación del contrato.
			contractDao.delete(deletedContract);
		}
	}

	@Override
	public Contract searchById(Long contractId) {
		// Resultado.
		Contract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del contrato por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {
		// Resultado.
		List<Contract> contractsList = new ArrayList<>();

		// Obtención de contratos.
		contractsList = contractDao.searchAll();

		return contractsList;
	}

	@Override
	public List<Contract> searchByClientId(Long clientId) {
		// Resultado.
		List<Contract> contractsList = new ArrayList<>();

		// Obtención del contrato por identificador del cliente.
		contractsList = contractDao.findByClientId(clientId);

		return contractsList;
	}

}
