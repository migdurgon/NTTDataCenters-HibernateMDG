/**
 * 
 */
package com.nttdata.hibernate;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Contract;
import com.nttdata.persistence.Client;
import com.nttdata.services.ClientManagementServiceI;
import com.nttdata.services.ClientManagementServiceImpl;

/**
 * @author Miguel Durán
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Apertura de sesión.
		final Session session = AppHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "APPSPORT_SYS";
		final Date updatedDate = new Date();

		// Generación de clientes.
		final Client clientA = new Client();
		clientA.setName("Miguel");
		clientA.setSurname("Durán");
		clientA.setSecondSurname("González");
		clientA.setDni("00000001X");
		clientA.setUpdatedDate(updatedDate);
		clientA.setUpdatedUser(updatedUser);
		

		final Client clientB = new Client();
		clientB.setName("Miguel");
		clientB.setSurname("Durán");
		clientB.setSecondSurname("González");
		clientB.setDni("0000002Z");
		clientA.setUpdatedDate(updatedDate);
		clientA.setUpdatedUser(updatedUser);
		;

		// Generación de contratos.
		final Contract contract1 = new Contract();
		contract1.setEffectiveDate(Date.from(Instant.now()));
		contract1.setExpiryDate(Date.from(Instant.now()));
		contract1.setClient(clientA);
		contract1.setUpdatedDate(updatedDate);
		contract1.setUpdatedUser(updatedUser);
		final Contract contract2 = new Contract();
		contract2.setEffectiveDate(Date.from(Instant.now()));
		contract2.setExpiryDate(Date.from(Instant.now()));
		contract2.setClient(clientA);
		contract2.setUpdatedDate(updatedDate);
		contract2.setUpdatedUser(updatedUser);
		final Contract contract3 = new Contract();
		contract3.setEffectiveDate(Date.from(Instant.now()));
		contract3.setExpiryDate(Date.from(Instant.now()));
		contract3.setClient(clientB);
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);
		final Contract contract4 = new Contract();
		contract4.setEffectiveDate(Date.from(Instant.now()));
		contract4.setExpiryDate(Date.from(Instant.now()));
		contract4.setClient(clientB);
		contract4.setUpdatedDate(updatedDate);
		contract4.setUpdatedUser(updatedUser);

		// Consultas (JPA Criteria)
		List<Client> clientsA = clientService.searchByName("Miguel");
		List<Client> clientsB = clientService.searchByNameAndSurnameAndSecondSurname("Miguel", "Durán", "González");

		for (final Client client : clientsA) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getSecondSurname());
		}

		for (final Client client : clientsB) {
			System.out.println(client.getName() + " | " + client.getSurname() + " | " + client.getSecondSurname());
		}

		// Cierre de sesión.
		session.close();

	}

}
