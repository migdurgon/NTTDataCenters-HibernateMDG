package com.nttdata.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * Entidad de tabla T_CLIENT
 * 
 * @author Miguel Durán
 *
 */
@Entity
@Table(name = "T_CLIENT")
public class Client extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clientId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String surname;

	/** Segundo apellido del cliente */
	private String secondSurname;

	/** DNI del cliente */
	private String dni;

	/** Lista de contratos */
	private List<Contract> contracts;
	
	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_PK_CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	@Column(name = "C_SURNAME")
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the secondSurname
	 */
	@Column(name = "C_SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the dni
	 */
	@Max(value = 9)
	@Min(value = 1)
	@Column(name = "C_DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the contracts
	 */
	@OneToMany(mappedBy = "client")
	public List<Contract> getContracts() {
		return contracts;
	}

	/**
	 * @param contracts the contracts to set
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public Long getId() {
		return clientId;
	}

	@Override
	public void setId(Long id) {
		this.clientId = id;
	}
	
	@Transient
	public Class<?> getClase() {
		return Client.class;
	}
}	