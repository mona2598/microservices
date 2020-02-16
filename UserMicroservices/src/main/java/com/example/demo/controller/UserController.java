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

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	UserService service;
	@PostMapping(value = "/saveAllData",headers = "Accept=application/json")
	public ResponseEntity<UserInfo> saveAllData(@Valid @RequestBody UserInfo info)
	{
		return new ResponseEntity<UserInfo>(service.saveDetails(info),HttpStatus.ACCEPTED);
	}
	@GetMapping(value = "/readAllData",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserInfo>> getAllUserData()
	{
		return new ResponseEntity<List<UserInfo>>(service.readAllData(),HttpStatus.FOUND);
	}
	@PutMapping(value = "/updateData",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> updateData(@RequestBody UserInfo info)
	{
		return new ResponseEntity<UserInfo>(service.updateData(info),HttpStatus.IM_USED);
	}
	@DeleteMapping(value = "/deleteData/{id}",headers = "Accept=application/json")
	public ResponseEntity<Void> deleteData(@PathVariable("id") Long id)
	{
		service.deleteData(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping(value = "/readData/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<UserInfo>> getOneData(@PathVariable("id") Long id)
	{
		return new ResponseEntity<Optional<UserInfo>>(service.getOne(id),HttpStatus.OK);
	}
}
