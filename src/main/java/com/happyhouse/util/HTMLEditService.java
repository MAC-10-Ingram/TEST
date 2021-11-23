package com.happyhouse.util;

import java.util.List;

public interface HTMLEditService {
	//HTML 파일 관리
	void deletePage(String uri) throws Exception;
	String updatePage(String uri, String title, List<String> body) throws Exception;
	String createPage(String title, List<String> body) throws Exception; //uri를 리턴
	public List<String> getBody(String uri) throws Exception;
	
	//HTML 내용 편집
}
