package com.happyhouse.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WikiDto {
	private String title;
	private List<String> body;
	private List<String> keyword;
	
}
