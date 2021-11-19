package com.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.happyhouse.model.QnaDto;

@Mapper
public interface QnaMapper {

	List<QnaDto> selectAll();
	QnaDto selectOne(int no);
	void addOne(QnaDto qna);
	void deleteOne(int no);
	void updateOne(QnaDto qna);
	List<QnaDto> searchByTitle(String title);
	List<String> getAnswers(int no);
	List<QnaDto> getQuestions();
}
