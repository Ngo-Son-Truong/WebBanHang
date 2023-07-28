package poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import poly.DAO.CategoryDAO;
import poly.DAO.ProductDAO;
import poly.model.Category;
import poly.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public Product save(Product entity) {
		return productDAO.save(entity);
	}
	
	@Override
	public List<Category> findAllCategory() {
		return (List<Category>)categoryDAO.findAll();
	}
	
	@Override
	public List<Product> findAll(Sort sort) {
		return (List<Product>)productDAO.findAll(sort);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productDAO.findAll(pageable);
	}

	@Override
	public List<Product> saveAll(List<Product> entities) {
		return (List<Product>)productDAO.saveAll(entities);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productDAO.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return productDAO.existsById(id);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>)productDAO.findAll();
	}

	@Override
	public List<Product> findAllById(List<Integer> ids) {
		return (List<Product>)productDAO.findAllById(ids);
	}

	@Override
	public long count() {
		return productDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		productDAO.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productDAO.delete(entity);
	}

	@Override
	public void deleteAll(List<Product> entities) {
		productDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDAO.deleteAll();
	}
		@Override
	public List<Product> getAllProductsByCategoryId(int id){
		return productDAO.findAllByCategory_Id(id);
	}
	
	@Override
	public Page<Product> findAll(Example<Product> example, Pageable pageable) {
		return productDAO.findAll(example, pageable);
	}
	
	@Override
    public Product findProductByID(int id) {
        for (Product product : productDAO.findAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}					