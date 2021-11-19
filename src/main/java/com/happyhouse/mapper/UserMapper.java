package com.happyhouse.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.happyhouse.model.UserInfoDto;

@Mapper
public interface UserMapper {

	void signUp(UserInfoDto userInfoDto) throws SQLException;
	UserInfoDto selectUser(String id) throws SQLException;
	void updateUser(UserInfoDto userInfoDto) throws SQLException;
	void deleteUser(String id) throws SQLException;
	UserInfoDto login(UserInfoDto userInfoDto) throws SQLException;
}
