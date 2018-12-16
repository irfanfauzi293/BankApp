package com.sti.appBank.controller;

import java.awt.Cursor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sti.appBank.dao.CustomerDao;
import com.sti.appBank.model.Customer;

@RestController
@RequestMapping("/customercontroller")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("/customer/{id}")
	public String getId(@PathVariable int id) {
		try {
			Customer customer = customerDao.getById(id);
			if(customer == null)
				return "Data Tidak Ditemukan";
			else
				return "Hello " + customer.getFirstName()+ " " + customer.getLastName();
		} catch (NumberFormatException e) {
			return "Salah Format Input";
		} catch (Exception e) {
		 return String.format("terjadi kesalahan sistem: %s", e.getMessage());
		}
		}
	
	@PostMapping("/customer")
	public Customer input(@RequestBody Customer customer) {
		try {
			customerDao.save(customer);
			return customer;
		} catch  (Exception e) {
			return null;
		}
	}
	
	@DeleteMapping("customer/{id}")
	public Customer delete(@PathVariable Customer customer) {
		try {
			customer.getCustomerNumber();
			customerDao.delete(customer);
			return customer;
		} catch (Exception e) {
			return null;
		}
	}
	
	}

