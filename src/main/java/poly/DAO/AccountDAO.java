package poly.DAO;

import org.springframework.data.repository.CrudRepository;

import poly.model.Account;

public interface AccountDAO extends CrudRepository<Account, String> {

}