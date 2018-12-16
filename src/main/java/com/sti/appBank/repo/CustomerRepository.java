package com.sti.appBank.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sti.appBank.model.Customer;


@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

}
