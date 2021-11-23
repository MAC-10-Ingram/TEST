package com.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.happyhouse.mapper.WikiMapper;
import com.happyhouse.model.WikiMetaDto;

public class WikiServiceImpl implements WikiService {
	@Autowired
	WikiMapper dao;

	@Override
	public List<WikiMetaDto> searchByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByTitle(title);
	}

	@Override
	public List<WikiMetaDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int noOfTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return dao.noOfTitle(title);
	}

	@Override
	public void insertPage(WikiMetaDto dto) throws Exception {
		// TODO Auto-generated method stub
		dao.insertPage(dto);
	}

	@Override
	public void updatePage(WikiMetaDto dto) throws Exception {
		// TODO Auto-generated method stub
		dao.updatePage(dto);
	}

	@Override
	public void deletePage(int no) throws Exception {
		// TODO Auto-generated method stub
		dao.deletePage(no);
	}

	@Override
	public List<WikiMetaDto> searchByKeyword(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByKeyword(keyword);
	}

	@Override
	public void insertKeyword(List<String> keyword) throws Exception {
		// TODO Auto-generated method stub
		
		for(String key : keyword) {
			if(dao.numOfKeyword(key) < 1) {
				dao.insertKeyword(key);
			}
		}
	}

	@Override
	public int noOfKeyword(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.noOfKeyword(keyword);
	}
	
	@Override
	public int numOfKeyword(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.numOfKeyword(keyword);
	}

	@Override
	public void insertPageKeyword(int pageno, int keyno) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageno", pageno);
		map.put("keyno", keyno);
		dao.insertPageKeyword(map);
	}

	@Override
	public void deletePageKeyword(int pageno, int keyno) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageno", pageno);
		map.put("keyno", keyno);
		dao.deletePageKeyword(map);

	}

}
