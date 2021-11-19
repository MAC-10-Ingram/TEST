package com.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SidoGugunCodeDto {
	
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
}
