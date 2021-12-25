package com.infinx.hackerbills.beans;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@Table(name = "BILL_DATA")
public class BillData {

	@Id
	@JsonIgnore
	@Column(name = "ID", columnDefinition = "VARCHAR(36)", nullable = false)
	private String id = UUID.randomUUID().toString();

	@Column(name = "BILL_ID", columnDefinition = "VARCHAR(36)", nullable = false)
	private String billId;

	@Column(name = "BILL_NUMBER", columnDefinition = "VARCHAR(36)", nullable = false)
	private String billNumber;

	@Column(name = "BILLED_TO", columnDefinition = "VARCHAR(30)", nullable = false)
	private String billedTo;

	@Column(name = "BILLED_DATE", columnDefinition = "VARCHAR(10)", nullable = false)
	private String billedDate;

	@Column(name = "BILLED_AMOUNT", precision = 10, scale = 3, nullable = false)
	private BigDecimal billedAmount;

	@Column(name = "TOTAL_AMOUNT", precision = 10, scale = 3, nullable = false)
	private BigDecimal totalAmount;

	@Column(name = "TAX", columnDefinition = "VARCHAR(30)")
	@JsonInclude(value = Include.NON_NULL)
	private String tax;
}
