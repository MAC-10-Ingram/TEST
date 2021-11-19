package com.happyhouse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QnaDto {
	private String no;
	private String title;
	private String content;
	private String questionNo;
	private String date;
	private String id;
}
