package com.happyhouse.service;

import java.util.List;

import com.happyhouse.model.QnaDto;

public interface QnaService {

	List<QnaDto> selectAll();
	QnaDto selectOne(String no);
	void addOne(QnaDto qna);
	void deleteOne(String no);
	void updateOne(QnaDto qna);
	List<QnaDto> searchByTitle(String title);
	List<String> getAnswers(String no);
	List<QnaDto> getQuestions();
}
