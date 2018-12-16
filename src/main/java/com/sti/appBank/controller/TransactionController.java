package com.sti.appBank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sti.appBank.dao.TransactionDao;
import com.sti.appBank.model.Transaction;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionDao transactionDao;
	
	@GetMapping("/transaction/{id}")
	public String getId(@PathVariable int id) {
		try {
			Transaction transaction = transactionDao.getById(id);
			if (transaction == null)
				return "Data Tidak Ditemukan";
			else
				return "Type = " + transaction.getType()+ " amount= " + transaction.getAmount();
		}
			catch (NumberFormatException e) {
				return "salah format input";
		} catch (Exception e) {
			return String.format("terjadi kesalahan sistem : %s", e.getMessage());
		}
		
	}
	
	@GetMapping("/transactions")
	public List<Transaction> allData() {
		try {
			List<Transaction> list = transactionDao.getList();
			return list;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/transaction")
	public Transaction input(@RequestBody Transaction transaction) {
		try {
			transactionDao.save(transaction);
			return transaction;
		} catch (Exception e) {
			
			return null;
		}
	}
	
	@DeleteMapping("/transaction/{id}")
	public Transaction delete(@RequestBody Transaction transaction) {
		
		try {
			transaction.getId();
			transactionDao.delete(transaction);
			return transaction;
			
		} catch (Exception e) {
			return null;
		}
	}
}
