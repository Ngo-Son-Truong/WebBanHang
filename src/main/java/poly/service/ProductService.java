package poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import poly.model.Category;
import poly.model.Product;


public interface ProductService {

	void deleteAll();

	void deleteAll(List<Product> entities);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	List<Product> findAllById(List<Integer> ids);

	List<Product> findAll();

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> saveAll(List<Product> entities);

	Page<Product> findAll(Pageable pageable);

	List<Product> findAll(Sort sort);

	Product save(Product entity);

	List<Category> findAllCategory();

	List<Product> getAllProductsByCategoryId(int id);
	
	Page<Product> findAll(Example<Product> example, Pageable pageable);
	
	public Product findProductByID(int id);

}
