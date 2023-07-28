package poly.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.model.Product;
import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	List<Product> findAllByCategory_Id(int id);
}
