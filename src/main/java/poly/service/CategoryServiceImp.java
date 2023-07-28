package poly.service;


import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.DAO.CategoryDAO;
import poly.model.Category;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public Category save(Category entity) {
		return categoryDAO.save(entity);
	}

	@Override
	public List<Category> saveAll(List<Category> entities) {
		return (List<Category>)categoryDAO.saveAll(entities);
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryDAO.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return categoryDAO.existsById(id);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>)categoryDAO.findAll();
	}

	@Override
	public List<Category> findAllById(List<Integer> ids) {
		return (List<Category>)categoryDAO.findAllById(ids);
	}

	@Override
	public long count() {
		return categoryDAO.count();
	}

	@Override
	public void deleteById(Integer id) {
		categoryDAO.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryDAO.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		categoryDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Category> entities) {
		categoryDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryDAO.deleteAll();
	}
	
	
	
}
