package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
@RestController
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;

	@PostMapping(value = "/save" ,headers = "Accept=application/json")
	public ResponseEntity<Category> saveCategories(@Valid @RequestBody Category category)
	{
		return new ResponseEntity<Category>(categoryService.saveCategories(category),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> readCategories()
	{
		return new ResponseEntity<List<Category>>(categoryService.readCategories(),HttpStatus.OK);
	}
	
	@PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> updateCategory(@Valid  @RequestBody Category category)
	{
		return new ResponseEntity<Category>(categoryService.updateCategory(category),HttpStatus.FOUND);
	}
	
	@DeleteMapping(value = "/delete/{id}",headers = "Accept=application/json")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id")Long id)
	{
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}
	
	@GetMapping(value = "/getOne/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Category>> getOneCategory(@PathVariable("id") Long id)
	{
		return new ResponseEntity<Optional<Category>>(categoryService.getOneCategory(id),HttpStatus.OK);
	}
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Void> deleteCategory()
	{
		categoryService.deleteAllCategory();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
