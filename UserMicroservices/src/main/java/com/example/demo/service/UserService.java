package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.dao.UserDaoInterface;
import com.example.demo.model.UserInfo;
@Service
public class UserService 
{
	@Autowired
	UserDaoInterface daoInterface;
	@Transactional
	public UserInfo saveDetails(UserInfo info)
	{
		return daoInterface.save(info);
	}
	@Transactional
	public List<UserInfo> readAllData()
	{
		return daoInterface.findAll();
	}
	@Transactional
	public UserInfo updateData(UserInfo info )
	{
		return daoInterface.save(info);	
		
	}
	@Transactional
	public void deleteData(Long id)
	{
		Optional<UserInfo>user=daoInterface.findById(id);
		if (user.get()== null) {
			throw new UserNotFoundException("User not found with id=" +id);
		}
		else {
		daoInterface.deleteById(id);}
	}
	@Transactional
	public Optional<UserInfo> getOne(Long id)
	{
		Optional<UserInfo> user =daoInterface.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found with id="+id);
		}
		else {
		return daoInterface.findById(id);
		}}

}
