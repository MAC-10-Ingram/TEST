package com.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.model.QnaDto;
import com.happyhouse.service.QnaService;

@RestController
@RequestMapping("/qna")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QnaController {

	@Autowired
	private QnaService service;
	
	@GetMapping("/")
	public List<QnaDto> selectAll() throws Exception {
		return service.selectAll();
	}
	
	@GetMapping("/questions")
	public List<QnaDto> getQuestions() throws Exception {
		return service.getQuestions();
	}
	
	@GetMapping("/{no}")
	public QnaDto selectOne(@PathVariable String no) throws Exception {
		return service.selectOne(no);
	}
	
	@PostMapping("/question")
	public void addQ(@RequestBody QnaDto qna) throws Exception {
		qna.setQuestionNo(null);
		service.addOne(qna);
	}
	
	@PostMapping("/answer")
	public void addA(@RequestBody QnaDto qna) throws Exception {
		service.addOne(qna);
	}
	
	@DeleteMapping("/{no}")
	public void deleteOne(@PathVariable String no) throws Exception {
		List<String> list = getAnswers(no);
		
		for(String str : list) {
			deleteOne(str);
		}
		
		service.deleteOne(no);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody QnaDto qna) throws Exception {
		service.updateOne(qna);
	}
	
	@GetMapping("/search")
	public List<QnaDto> searchByTitle(@RequestParam("title") String title) throws Exception {
		return service.searchByTitle(title);
	}
	
	@GetMapping("/{no}/answers")
	public List<String> getAnswers(@PathVariable String no) throws Exception {
		return service.getAnswers(no);
	}
}
