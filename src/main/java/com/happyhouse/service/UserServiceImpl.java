package com.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.mapper.UserMapper;
import com.happyhouse.model.UserInfoDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void signUp(UserInfoDto userInfoDto) throws Exception {
		userMapper.signUp(userInfoDto);
	}

	@Override
	public UserInfoDto selectUser(String id) throws Exception {
		return userMapper.selectUser(id);
	}

	@Override
	public void updateUser(UserInfoDto userInfoDto) throws Exception {
		userMapper.updateUser(userInfoDto);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		userMapper.deleteUser(id);
	}

	@Override
	public UserInfoDto login(UserInfoDto userInfoDto) throws Exception {
		return userMapper.login(userInfoDto);
	}

}
