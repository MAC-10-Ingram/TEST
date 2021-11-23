package com.happyhouse.service;

import java.io.IOException;
import java.util.List;

import com.happyhouse.model.NewsDto;

public interface NewsService {
	List<NewsDto> getNewsDatas() throws IOException;
}
