package com.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.mapper.QnaMapper;
import com.happyhouse.model.QnaDto;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaMapper dao;

	@Override
	public List<QnaDto> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public QnaDto selectOne(String no) {
		// TODO Auto-generated method stub
		return dao.selectOne(Integer.parseInt(no));
	}

	@Override
	public void deleteOne(String no) {
		// TODO Auto-generated method stub
		dao.deleteOne(Integer.parseInt(no));
	}

	@Override
	public void updateOne(QnaDto qna) {
		// TODO Auto-generated method stub
		dao.updateOne(qna);
	}

	@Override
	public List<QnaDto> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.searchByTitle(title);
	}

	@Override
	public void addOne(QnaDto qna) {
		// TODO Auto-generated method stub
		dao.addOne(qna);
	}

	@Override
	public List<String> getAnswers(String no) {
		// TODO Auto-generated method stub
		return dao.getAnswers(Integer.parseInt(no));
	}

	@Override
	public List<QnaDto> getQuestions() {
		// TODO Auto-generated method stub
		return dao.getQuestions();
	}
	


}
