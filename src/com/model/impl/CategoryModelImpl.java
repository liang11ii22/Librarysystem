package com.model.impl;

import com.daos.CategoryDao;
import com.daos.impl.CategoryDaoImpl;
import com.dtos.Category;
import com.model.CategoryModel;

public class CategoryModelImpl extends BaseModelImpl<Category> implements CategoryModel{
	private CategoryDao categoryDao = new CategoryDaoImpl();

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	

}
