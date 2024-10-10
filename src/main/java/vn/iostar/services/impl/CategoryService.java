package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDao;
import vn.iostar.entities.Category;
import vn.iostar.services.ICategoryService;

public class CategoryService implements ICategoryService {

	ICategoryDao catDao = new CategoryDao();
	
	@Override
	public List<Category> findByCategoryname(String categoryname) {
		return catDao.findByCategoryname(categoryname);
	}

	@Override
	public List<Category> findAll() {
		return catDao.findAll();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		return catDao.findAll(page, pagesize);
	}

	@Override
	public Category findById(int categoryid) {
		return catDao.findById(categoryid);
	}

	@Override
	public void delete(int categoryid) throws Exception {
		catDao.delete(categoryid);	
	}

	@Override
	public void update(Category category) {
		catDao.update(category);
	}

	@Override
	public void insert(Category category) {
		catDao.insert(category);
	}

	@Override
	public int count() {
		return catDao.count();
	}

}
