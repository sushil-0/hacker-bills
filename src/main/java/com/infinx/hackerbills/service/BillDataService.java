package com.infinx.hackerbills.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinx.hackerbills.beans.BillData;
import com.infinx.hackerbills.dao.BillDataDAO;

@Service
public class BillDataService {

	@Autowired
	private BillDataDAO billDataDAO;

	public List<BillData> getAllBillsData() {
		return billDataDAO.findAll();
	}

	public Optional<BillData> getBillsDataById(String id) {
		return billDataDAO.findByBillId(id);
	}

	public List<BillData> getAllBillsDataByDueDate(String billedDate) {
		return billDataDAO.findByBilledDate(billedDate);
	}

	public BillData addNewBillData(BillData billData) {
		billData.setId(UUID.randomUUID().toString());
		return billDataDAO.save(billData);
	}
}
