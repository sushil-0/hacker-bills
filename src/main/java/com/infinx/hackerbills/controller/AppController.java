package com.infinx.hackerbills.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinx.hackerbills.beans.BillData;
import com.infinx.hackerbills.service.BillDataService;

@RestController
public class AppController {
	
	@Autowired
	private BillDataService billDataService;

	/**
	 * Fetch all bills details
	 * 
	 * @return List
	 */
	@GetMapping(value = "/bills")
	public ResponseEntity<List<BillData>> getBills() {
		List<BillData> response = billDataService.getAllBillsData();
		return new ResponseEntity<List<BillData>>(response, HttpStatus.OK);
	}

	/**
	 * Fetch bill details by Id
	 * 
	 * @param id
	 * @return {@link BillData}
	 */
	@GetMapping("/bills/{id}")
	public ResponseEntity<BillData> getBillsById(@PathVariable(value = "id") String id) {
		Optional<BillData> response = billDataService.getBillsDataById(id);
		if (!response.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BillData>(response.get(), HttpStatus.OK);
	}

	/**
	 * Fetch bill details by due date
	 * 
	 * @param date
	 * @return
	 */
	@GetMapping("/bills/due/{date}")
	public ResponseEntity<List<BillData>> getBillsByDate(@PathVariable(name = "date") String date) {
		List<BillData> response = billDataService.getAllBillsDataByDueDate(date);
		return new ResponseEntity<List<BillData>>(response, HttpStatus.OK);
	}

	@PostMapping("/bills/add")
	public ResponseEntity<BillData> addBillsWithDueDate(@NonNull @RequestBody BillData billData ) {
		BillData response = billDataService.addNewBillData(billData);
		return new ResponseEntity<BillData>(response, HttpStatus.OK);
	}

	
}
