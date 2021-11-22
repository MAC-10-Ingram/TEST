package com.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.happyhouse.model.QnaDto;

public interface QnaService {

	List<QnaDto> selectAll() throws Exception;
	QnaDto selectOne(String no) throws Exception;
	void addOne(QnaDto qna) throws Exception;
	void deleteOne(String no) throws Exception;
	void deleteAnswer(String no) throws Exception;
	void updateOne(QnaDto qna) throws Exception;
	List<QnaDto> searchByTitle(String title) throws Exception;
	List<String> getAnswers(String no) throws Exception;
	List<QnaDto> getQuestions() throws Exception;
}
