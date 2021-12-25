package com.infinx.hackerbills;

import java.math.BigDecimal;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infinx.hackerbills.beans.BillData;
import com.infinx.hackerbills.dao.BillDataDAO;

@SpringBootApplication
public class HackerBillsApplication {

	@Autowired
	BillDataDAO dao;

	
//	Testing
	@PostConstruct
	void init() {
		for (int i = 0; i < 5; i++) {
			BillData data = new BillData();
			data.setBillId(UUID.randomUUID().toString());
			data.setBilledAmount(new BigDecimal(1212));
			data.setBilledTo("name" + i);
			data.setBilledDate("26-10-2" + i);
			data.setTax("");
			data.setBillNumber("n" + i);
			data.setTotalAmount(new BigDecimal(i));
			dao.save(data);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HackerBillsApplication.class, args);
	}

}
