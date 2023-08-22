package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import com.app.dao.UserDao;
import com.app.dto.MyApiResponse;
import com.app.dto.SignInRequest;
import com.app.dto.SignInResp;
import com.app.dto.SignupRequest;
import com.app.dto.SignupResp;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

@Autowired
private UserDao uDao;

@Autowired
private ModelMapper mapper;

@Override
public List<SignupResp> getAllUsers() {
List<User> list = uDao.findAll();
return list.stream()
		.map(user -> mapper.map(user, SignupResp.class)).collect(Collectors.toList());
}

@Override
public MyApiResponse deleteUser(Long uId) {
User uu=getById(uId);
uDao.delete(uu);
return new MyApiResponse("User Deleted Successfully");
}

public User getById(Long uId) {
return uDao.findById(uId).orElseThrow(()->new com.app.custom_exception.ResourceNotFoundException("User Not Found") );
}

@Override
public MyApiResponse updateUser(Long uId, SignupRequest user) {

	User needToUpdate =uDao.findById(uId).orElseThrow(() -> new com.app.custom_exception.ResourceNotFoundException("User id not exists!"));
	mapper.map(user , needToUpdate);
	needToUpdate.setUserId(uId);
	
	return new MyApiResponse("User updated successfully!");
}

}