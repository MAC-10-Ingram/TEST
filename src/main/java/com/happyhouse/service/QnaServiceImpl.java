package com.happyhouse.service;

import java.sql.SQLException;
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
	public List<QnaDto> selectAll()  throws Exception{
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public QnaDto selectOne(String no) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectOne(Integer.parseInt(no));
	}

	@Override
	public void deleteOne(String no) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteOne(Integer.parseInt(no));
	}

	@Override
	public void updateOne(QnaDto qna) throws Exception {
		// TODO Auto-generated method stub
		dao.updateOne(qna);
	}

	@Override
	public List<QnaDto> searchByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByTitle(title);
	}

	@Override
	public void addOne(QnaDto qna) throws Exception {
		// TODO Auto-generated method stub
		dao.addOne(qna);
	}

	@Override
	public List<String> getAnswers(String no) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAnswers(Integer.parseInt(no));
	}

	@Override
	public List<QnaDto> getQuestions() throws Exception {
		// TODO Auto-generated method stub
		return dao.getQuestions();
	}

	@Override
	public void deleteAnswer(String no) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteAnswer(Integer.parseInt(no));
	}
	


}
