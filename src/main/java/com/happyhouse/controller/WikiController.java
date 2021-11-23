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
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.model.WikiDto;
import com.happyhouse.model.WikiMetaDto;
import com.happyhouse.service.WikiService;
import com.happyhouse.util.HTMLEditService;

@RestController
@RequestMapping("/wiki")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WikiController {
	
	@Autowired
	private WikiService wiki;
	
	@Autowired
	private HTMLEditService html;
	
	//새 문서 생성
	@PostMapping("/create")
	void createPage(@RequestBody WikiDto input) throws Exception {
		//문서 생성
		String uri = html.createPage(input.getTitle(), input.getBody());
		
		//db에 문서 추가
		WikiMetaDto dto = new WikiMetaDto();
		dto.setTitle(input.getTitle());
		dto.setUri(uri);
		wiki.insertPage(dto);
		
		//db에 키워드 추가
		wiki.insertKeyword(input.getKeyword());
		
		//db에 키워드와 wiki 연결 관계 추가
		int pageno = wiki.noOfTitle(input.getTitle());
		for(String key : input.getKeyword()) {
			int keyno = wiki.noOfKeyword(key);
			wiki.insertPageKeyword(pageno, keyno);
		}
	}
	
	//문서 Body 가져오기
	@GetMapping("/body/{uri}")
	List<String> getBody(@PathVariable String uri) throws Exception{
		return html.getBody(uri);
	}
	
	//문서 업데이트하기
	@PutMapping("/update/{uri}")
	void updatePage(@PathVariable String uri,@RequestBody String title, @RequestBody List<String> body) throws Exception{
		uri = html.updatePage(uri, title, body);
		WikiMetaDto dto = new WikiMetaDto();
		dto.setTitle(title);
		dto.setUri(uri);
		dto.setNo(wiki.noOfTitle(title));
		wiki.updatePage(dto);
	}
	//문서 삭제하기
	@DeleteMapping("/delete/{no}")
	void deletePage(@PathVariable int no) throws Exception{
		wiki.deletePageKeyword(no);
		wiki.deletePage(no);
	}
	
	//문서 읽기//uri로 직접 접근
	
	//타이틀 검색
	@GetMapping("/title/{title}")
	List<WikiMetaDto> searchByTitle(@PathVariable String title) throws Exception{
		return wiki.searchByTitle(title);
	} 
	
	//키워드 검색
	@GetMapping("/keyword/{keyword}")
	List<WikiMetaDto> searchByKeyword(@PathVariable String keyword) throws Exception{
		return wiki.searchByKeyword(keyword);
	} 
	
	//문서 목록 가져오기
	@GetMapping("/")
	List<WikiMetaDto> selectAll() throws Exception{
		System.out.println("call wiki list");
		return wiki.selectAll();
	} 
}
