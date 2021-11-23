package com.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.happyhouse.model.WikiMetaDto;

@Mapper
public interface WikiMapper {
	List<WikiMetaDto> searchByTitle(String title) throws SQLException;
	List<WikiMetaDto> selectAll() throws SQLException;
	int noOfTitle(String title) throws SQLException;
	void insertPage(WikiMetaDto dto) throws SQLException;
	void updatePage(WikiMetaDto dto) throws SQLException;
	void deletePage(int no) throws SQLException;
	
	List<WikiMetaDto> searchByKeyword(String keyword) throws SQLException;
	void insertKeyword(String keyword) throws SQLException;
	int noOfKeyword(String keyword) throws SQLException;
	int numOfKeyword(String keyword) throws SQLException;
	
	void insertPageKeyword(Map map) throws SQLException;
	void deletePageKeyword(int pageno) throws SQLException;
}
