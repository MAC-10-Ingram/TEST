package com.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseInfoDto {
	
	private String aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private String sidoName;
	private String gugunName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	private String recentPrice;	
	private String distance;
	private String jwt;
	private String dongCount;
}
