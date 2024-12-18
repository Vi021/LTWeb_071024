package vn.iostar.services;

import java.util.List;

import vn.iostar.entities.Category;

public interface ICategoryService {

	List<Category> findByCategoryname(String categoryname);

	List<Category> findAll();

	List<Category> findAll(int page, int pagesize);

	Category findById(int categoryid);

	void delete(int categoryid) throws Exception;

	void update(Category category);

	void insert(Category category);

	int count();
	
}
