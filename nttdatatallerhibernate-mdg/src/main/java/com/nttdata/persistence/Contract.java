/**
 * 
 */
package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.JoinColumn;

/**
 * Entidad de tabla T_CONTRACT
 * 
 * @author Miguel Durán
 *
 */
@Entity
@Table(name = "T_CONTRACT")
public class Contract extends AbstractEntity implements Serializable  {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha vigencia del contrato */
	private Date effectiveDate;

	/** Fecha caducidad del contrato */
	private Date expiryDate;

	/** Precio mensual */
	private Double monthlyPrice;

	/** Cliente */
	private Client client;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_PK_CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the effectiveDate
	 */
	@Column(name = "C_EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expiryDate
	 */
	@Column(name = "C_EXPIRY_DATE")
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the monthlyPrice
	 */
	@Column(name = "C_MONTHLY_PRICE")
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param monthlyPrice the monthlyPrice to set
	 */
	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * @return the client
	 */
	@ManyToOne()
	@JoinColumn(name = "C_FK_ID_CLIENT")
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public Long getId() {
		return this.contractId;
	}

	@Override
	public void setId(Long id) {
		this.contractId = id;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}
	
}
