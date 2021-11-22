package com.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.happyhouse.service.JwtServiceImpl;
import com.happyhouse.service.QnaService;

@RestController
@RequestMapping("/qna")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QnaController {

	public static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
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
	public ResponseEntity<Map<String, Object>> addQ(
			@RequestBody QnaDto qna,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			
			if(jwtService.getUserId().equals(qna.getId())) {
				try {
					qna.setQuestionNo(null);
					service.addOne(qna);
					resultMap.put("message", SUCCESS);
					status = HttpStatus.ACCEPTED;
				} catch (Exception e) {
					logger.error("질문 추가 실패 : {}", e);
					resultMap.put("message", e.getMessage());
					status = HttpStatus.INTERNAL_SERVER_ERROR;
				}
			}else {
				logger.error("아이디 불일치!!!");
				resultMap.put("message", FAIL);
				status = HttpStatus.BAD_REQUEST;
			}
			
			
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/answer")
	public ResponseEntity<Map<String, Object>> addA(
			@RequestBody QnaDto qna,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			
			if(jwtService.getUserId().equals(qna.getId())) {
				try {
					service.addOne(qna);
					resultMap.put("message", SUCCESS);
					status = HttpStatus.ACCEPTED;
				} catch (Exception e) {
					logger.error("댓글 추가 실패 : {}", e);
					resultMap.put("message", e.getMessage());
					status = HttpStatus.INTERNAL_SERVER_ERROR;
				}
			}else {
				logger.error("아이디 불일치!!!");
				resultMap.put("message", FAIL);
				status = HttpStatus.BAD_REQUEST;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity<Map<String, Object>> deleteQ (
			@PathVariable String no,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			
			try {
				if(jwtService.getUserId().equals(selectOne(no).getId())) {
					service.deleteAnswer(no);
					service.deleteOne(no);
					resultMap.put("message", SUCCESS);
					status = HttpStatus.ACCEPTED;
				
				}else {
					logger.error("아이디 불일치!!!");
					resultMap.put("message", FAIL);
					status = HttpStatus.BAD_REQUEST;
				}
			} catch (Exception e) {
				logger.error("삭제 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> update(
			@RequestBody QnaDto qna,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			
			if(jwtService.getUserId().equals(qna.getId())) {
				try {
					service.updateOne(qna);
					resultMap.put("message", SUCCESS);
					status = HttpStatus.ACCEPTED;
				} catch (Exception e) {
					logger.error("정보조회 실패 : {}", e);
					resultMap.put("message", e.getMessage());
					status = HttpStatus.INTERNAL_SERVER_ERROR;
				}
			}else {
				logger.error("아이디 불일치!!!");
				resultMap.put("message", FAIL);
				status = HttpStatus.BAD_REQUEST;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
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
