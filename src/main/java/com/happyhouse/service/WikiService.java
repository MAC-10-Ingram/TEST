package com.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.happyhouse.model.QnaDto;
import com.happyhouse.model.WikiMetaDto;

public interface WikiService {

	List<WikiMetaDto> searchByTitle(String title) throws Exception;
	List<WikiMetaDto> selectAll() throws Exception;
	int noOfTitle(String title) throws Exception;
	void insertPage(WikiMetaDto dto) throws Exception;
	void updatePage(WikiMetaDto dto) throws Exception;
	void deletePage(int no) throws Exception;
	
	List<WikiMetaDto> searchByKeyword(String keyword) throws Exception;
	void insertKeyword(List<String> keyword) throws Exception;
	int noOfKeyword(String keyword) throws Exception;
	public int numOfKeyword(String keyword) throws Exception;
	
	void insertPageKeyword(int pageno, int keyno) throws Exception;
	void deletePageKeyword(int pageno) throws Exception;
}
