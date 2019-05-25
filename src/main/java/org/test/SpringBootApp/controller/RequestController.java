/**
 * Controller class for the App.
 */

package org.test.SpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.SpringBootApp.pojo.CustomerAccount;
import org.test.SpringBootApp.service.RequestServiceProcessor;

@RestController
public class RequestController {

	@Autowired
	private RequestServiceProcessor requestProcessor;

	@GetMapping(value = "/Customer/details", consumes = "application/json", produces = "application/json")
	@RequestMapping("/Customer/details")
	public String getCustomerDetails() {
		return "Yaswanth";

	}

	@PostMapping(value = "/Customer/details/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerAccount> postCustomerToDatabase(@RequestBody final CustomerAccount customerAccount,
			@PathVariable final int id) {
		return ResponseEntity.accepted().body(requestProcessor.insertValuesIntoDatabase(customerAccount));



	}

}
