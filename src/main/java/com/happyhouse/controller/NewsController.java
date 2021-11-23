package com.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.model.NewsDto;
import com.happyhouse.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/")
	public ResponseEntity<List<NewsDto>> sido() throws Exception {
		return new ResponseEntity<List<NewsDto>>(newsService.getNewsDatas(), HttpStatus.OK);
	}
}
