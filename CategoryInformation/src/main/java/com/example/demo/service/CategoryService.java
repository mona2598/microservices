package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository daoInterface;
	
	@Transactional
	public Category saveCategories(Category category)
	{
		return daoInterface.save(category);
	}
	
	@Transactional
	public List<Category> readCategories()
	{
		return daoInterface.findAll();
	}
	
	@Transactional
	public Category updateCategory(Category category)
	
	{
		return daoInterface.save(category);
	}
	
	@Transactional
	public void  deleteCategory(Long id)
	{
		Optional<Category>deleteCategoryById=daoInterface.findById(id);
		if(!deleteCategoryById.isPresent())
		{
			throw new CategoryNotFoundException("Category not delete ; "+id);
	
		}
		daoInterface.deleteById(id);
	}
	
	@Transactional
	public Optional<Category> getOneCategory(Long id)
	{
		Optional<Category> findCategoryById = daoInterface.findById(id);
		if(!findCategoryById.isPresent()) {
			throw new CategoryNotFoundException("Category not found ; "+id);
		}
		return findCategoryById;
	}
	
	@Transactional
	public void deleteAllCategory()
	{
		daoInterface.deleteAll();
	}
}
