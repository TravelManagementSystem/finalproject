package com.app.service;

import java.util.List;

import com.app.dto.MyApiResponse;
import com.app.dto.SignInRequest;
import com.app.dto.SignInResp;
import com.app.dto.SignupRequest;
import com.app.dto.SignupResp;

public interface UserService {

	List<SignupResp> getAllUsers();

	MyApiResponse deleteUser(Long uId);

	MyApiResponse updateUser(Long uId, SignupRequest user);
}
