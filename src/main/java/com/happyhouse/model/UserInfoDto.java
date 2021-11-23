package com.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
	
	private String id;
	private String password;
	private String email;
	private String name;
	private String lat;
	private String lng;
	private String address;
}
