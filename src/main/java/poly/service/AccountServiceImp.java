package poly.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.DAO.AccountDAO;
import poly.model.Account;



@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDAO accountDAO;

	@Override
	public Account save(Account entity) {
		return accountDAO.save(entity);
	}

	@Override
	public List<Account> saveAll(List<Account> entities) {
		return (List<Account>)accountDAO.saveAll(entities);
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountDAO.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return accountDAO.existsById(id);
	}

	@Override
	public List<Account> findAll() {
		return (List<Account>)accountDAO.findAll();
	}

	@Override
	public List<Account> findAllById(List<String> ids) {
		return (List<Account>)accountDAO.findAllById(ids);
	}

	@Override
	public long count() {
		return accountDAO.count();
	}

	@Override
	public void deleteById(String id) {
		accountDAO.deleteById(id);
	}

	@Override
	public void delete(Account entity) {
		accountDAO.delete(entity);
	}

	@Override
	public void deleteAll(List<Account> entities) {
		accountDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		accountDAO.deleteAll();
	}
	
	@Override
	public boolean checklogin(String email, String password) {
		Optional<Account> optionalacc = findById(email);
		if (optionalacc.isPresent() && optionalacc.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
}