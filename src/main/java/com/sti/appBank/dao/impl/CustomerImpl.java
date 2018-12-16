package com.sti.appBank.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.sti.appBank.dao.CustomerDao;
import com.sti.appBank.model.Customer;
import com.sti.appBank.repo.CustomerRepository;

public class CustomerImpl extends BaseImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getById(int id) throws Exception {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer save(Customer customer) throws Exception {
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Customer customer) throws Exception {
		customerRepository.delete(customer);
		
	}

	@Override
	public List<Customer> getList() throws Exception {
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Customer> query = critB.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
		query.select(root);
		
		TypedQuery<Customer> q= em.createQuery(query);
		
		return q.getResultList();
	}
	
	

}
