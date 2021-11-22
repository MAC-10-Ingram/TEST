package com.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.happyhouse.model.QnaDto;

@Mapper
public interface QnaMapper {

	List<QnaDto> selectAll() throws SQLException;
	QnaDto selectOne(int no) throws SQLException;
	void addOne(QnaDto qna) throws SQLException;
	void deleteOne(int no) throws SQLException;
	void deleteAnswer(int no) throws SQLException;
	void updateOne(QnaDto qna) throws SQLException;
	List<QnaDto> searchByTitle(String title) throws SQLException;
	List<String> getAnswers(int no) throws SQLException;
	List<QnaDto> getQuestions() throws SQLException;
}
