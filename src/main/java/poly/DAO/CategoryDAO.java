package poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.model.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
