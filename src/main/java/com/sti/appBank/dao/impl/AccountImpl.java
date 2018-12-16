package com.sti.appBank.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.sti.appBank.dao.AccountDao;
import com.sti.appBank.model.Account;
import com.sti.appBank.repo.AccountRepository;

public class AccountImpl extends BaseImpl implements AccountDao{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getById(int id) throws Exception {
		return accountRepository.findOne(id);
	}

	@Override
	public Account save(Account account) throws Exception {
		return accountRepository.save(account);
	}

	@Override
	public void delete(Account account) throws Exception {
	 accountRepository.delete(account);
		
	}

	@Override
	public List<Account> getList() throws Exception {
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Account> query = critB.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		query.select(root);
		
		TypedQuery<Account> q= em.createQuery(query);
		
		return q.getResultList();
	}

}
