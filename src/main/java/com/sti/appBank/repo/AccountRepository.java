package com.sti.appBank.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sti.appBank.model.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account,Integer> {
	
}
