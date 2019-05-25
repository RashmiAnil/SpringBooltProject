package org.test.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.test.SpringBootApp.pojo.CustomerAccount;

@Service
public class RequestServiceProcessor {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	

	public CustomerAccount insertValuesIntoDatabase(final CustomerAccount customerAccount) {
		String sql = "INSERT INTO CUSTOMERACCOUNT " + "(id, firstName, lastName) VALUES (?, ?, ?)";

		jdbcTemplate.update(sql, new Object[] { customerAccount.getId(), customerAccount.getFirstName(),
				customerAccount.getLastName() });

		return customerAccount;

	}

}
