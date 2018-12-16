package com.sti.appBank.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.sti.appBank.dao.TransactionDao;
import com.sti.appBank.model.Customer;
import com.sti.appBank.model.Transaction;
import com.sti.appBank.repo.TransactionRepository;

public class TransactionImpl extends BaseImpl implements TransactionDao {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction getById(int id) throws Exception {
		return transactionRepository.findOne(id);
	}

	@Override
	public Transaction save(Transaction transaction) throws Exception {
		return transactionRepository.save(transaction);
	}

	@Override
	public void delete(Transaction transaction) throws Exception {
		transactionRepository.delete(transaction);
		
	}

	@Override
	public List<Transaction> getList() throws Exception {
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> query = critB.createQuery(Transaction.class);
		Root<Transaction> root = query.from(Transaction.class);
		query.select(root);
		
		TypedQuery<Transaction> q= em.createQuery(query);
		
		return q.getResultList();
	}
	
	

}
