package com.sti.appBank.dao;

import java.util.List;

import com.sti.appBank.model.Account;

public interface AccountDao {
	
	Account getById(int id) throws Exception;
	Account save(Account account) throws Exception;
	void delete(Account account) throws Exception;
	
	List<Account> getList() throws Exception;

}
