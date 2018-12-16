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

import com.sti.appBank.dao.AccountDao;
import com.sti.appBank.model.Account;

@RestController
@RequestMapping("/accountcontroller")
public class AccountController {
	
	@Autowired
	private AccountDao accountDao;
	
	@GetMapping("/account/{id}")
	public String getId(@PathVariable int id) {
		try {
			Account account = accountDao.getById(id);
			if (account == null)
				return "data tidak ditemukan";
			else
				return "hello " + account.getBalance() + " " + account.getCustomer();
		} catch (NumberFormatException e) {
			return "Salah Format Input";
		} catch (Exception e) {
		 return String.format("terjadi kesalahan sistem: %s", e.getMessage());
		}
	}
	
	@GetMapping("/accounts")
	public List<Account> allData() {
		try {
			List<Account> list = accountDao.getList();
			return list;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/account")
	public Account input(@RequestBody Account account) {
		try {
			account = accountDao.save(account);
			return account;
		} catch (Exception e) {
			
			return null;
		}
	}
	
	@DeleteMapping("/account/{id}")
	public Account delete(@PathVariable Account account) {
		
		try {
			account.getAccountNumber();
			accountDao.delete(account);
			return account;
			
		} catch (Exception e) {
			return null;
		}
	}
		
}

