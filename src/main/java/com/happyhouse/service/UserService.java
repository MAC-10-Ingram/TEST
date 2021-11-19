package com.happyhouse.service;

import com.happyhouse.model.UserInfoDto;

public interface UserService {

	void signUp(UserInfoDto userInfoDto) throws Exception;
	UserInfoDto selectUser(String id) throws Exception;
	void updateUser(UserInfoDto userInfoDto) throws Exception;
	void deleteUser(String id) throws Exception;
	UserInfoDto login(UserInfoDto userInfoDto) throws Exception;
}
