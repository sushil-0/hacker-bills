package com.infinx.hackerbills.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinx.hackerbills.beans.BillData;

public interface BillDataDAO extends JpaRepository<BillData, String> {

	/**
	 * Fetch details by bill Id
	 * 
	 * @param billId
	 * @return {@link Optional}
	 */
	Optional<BillData> findByBillId(String billId);

	/**
	 * Fetch details by due bill date
	 * 
	 * @param billDate
	 * @return {@link List}
	 */
	List<BillData> findByBilledDate(String billDate);
}
