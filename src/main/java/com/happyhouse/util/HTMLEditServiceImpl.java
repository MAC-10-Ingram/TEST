package com.happyhouse.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class HTMLEditServiceImpl implements HTMLEditService {
	
	private final String base = "/wikipage/";
	
	@Override
	public void deletePage(String uri) throws Exception {
		// TODO Auto-generated method stub
		ClassPathResource resource = new ClassPathResource(uri); 
		File file = resource.getFile(); 
		if( file.exists() ){ 
			createFile(uri+".BCK", getBody(uri));
			
			if(file.delete()){ 
				System.out.println("파일삭제 성공"); 
			}else{ 
				System.out.println("파일삭제 실패"); 
			} 
		}else{ 
			System.out.println("파일이 존재하지 않습니다."); 
		}

	}
	
	public List<String> getBody(String uri) throws Exception{
		ClassPathResource resource = new ClassPathResource(uri); 
		Path path = Paths.get(resource.getURI());
		List<String> list = Files.readAllLines(path);
		List<String> body = new LinkedList<String>();
		
		int i = 0;
		while(i < list.size() && !list.get(i).contains("<body>") ) {
			i++;
		}
		
		i++;
		
		while(i < list.size() && !list.get(i).contains("</body>") ) {
			body.add(list.get(i));
			i++;
		}
		
		return body;
		
	}

	@Override
	public String updatePage(String uri, String title, List<String> body) throws Exception {
		// TODO Auto-generated method stub
		deletePage(uri);
		return createPage(title, body);        
	}

	@Override
	public String createPage(String title, List<String> body) throws Exception {
		// TODO Auto-generated method stub
		
		String uri = base+title+".html"; // 대상 파일
		List<String> content = new LinkedList<String>();
		
		content.add("<!DOCTYPE html>\r\n");
		content.add("<html lang=\"en\">\r\n");
		content.add("<head>\r\n");
		content.add("    <meta charset=\"UTF-8\">\r\n");
		content.add("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
		content.add("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
		content.add("    <title>");
		content.add(title);
		content.add("</title>\r\n");
		content.add("</head>\r\n");
		content.add("<body>\r\n");
		content.addAll(body);
		content.add("</body>\r\n");
		content.add("</html>");
		
        createFile(uri, content);
        
		return uri;//문서의 경로를 반환
	}
	
	private void createFile(String uri, List<String> content) throws Exception {
		ClassPathResource resource = new ClassPathResource(uri); 
		File tempfile = new File(resource.getURI());
		Path path = Paths.get(resource.getURI()); 
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toString(), false));
		bufferedWriter.write("");
		for(String line : content) {
			bufferedWriter.write(line);
		}
		bufferedWriter.newLine(); 
		bufferedWriter.flush(); 
		bufferedWriter.close();
	}

}
