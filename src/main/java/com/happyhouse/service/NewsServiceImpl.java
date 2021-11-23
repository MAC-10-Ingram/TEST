package com.happyhouse.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.happyhouse.model.NewsDto;

@Service
public class NewsServiceImpl implements NewsService {
	
	private static String NEWS_URL = "https://land.naver.com/";
	
	List<NewsDto> newsList;
	String s, url, title;
	
	@Override
	@PostConstruct
	public List<NewsDto> getNewsDatas() throws IOException {
		newsList = new ArrayList<>();
		Document doc = Jsoup.connect(NEWS_URL).get();
		Elements contents = doc.select(".section_l>div>ul");
		for (Element e1 : contents) {
			Elements temp = e1.select("li>a");
			for (Element e2 : temp) {
				s = e2.attr("href");
				url = s.substring(s.length()-10, s.length());
				title = e2.attr("title");
				newsList.add(new NewsDto(title,url));
			}
        }
		return newsList;
	}

}
