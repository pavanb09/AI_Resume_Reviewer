package com.example.resumereviewer.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * RestTemplate is a spring clined
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.resumereviewer.dto.ApiResponse;
import com.example.resumereviewer.dto.ResumeRequest;
import com.example.resumereviewer.dto.ResumeResponse;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ResumeController {
	
	@Autowired
	private RestTemplate template;

	private final String API_URL = "https://api.groq.com/openai/v1/chat/completions";
	
	@Value("${groq.api.key}")
	private String API_KEY;
	
	@PostMapping("/review")
	public ResponseEntity<ApiResponse<ResumeResponse>> reviewResume(@RequestBody ResumeRequest resume){
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(API_KEY);
		
		String prompt =
		        "Review the following resume and give structured feedback.\n\n" +
		        "Feedback format:\n" +
		        "1. Overall Summary\n" +
		        "2. Strengths\n" +
		        "3. Areas for Improvement\n" +
		        "4. Score (out of 10)\n\n" +
		        "Resume:\n" +
		        resume.getResumeText();
		
		
		Map<String,Object> message = new HashMap<>();
		message.put("role", "user");
		message.put("content", prompt);
		
		Map<String,Object> body = new HashMap<>();
		body.put("model", "llama-3.1-8b-instant");
		body.put("messages", List.of(message));
		
		
		
		
		HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body,headers);
		
		ResponseEntity<String> responseEn = template.postForEntity(API_URL, entity, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(responseEn.getBody());
		
		String feedback = root
				.path("choices")
				.get(0)
				.path("message")
				.path("content")
				.asText();
		
		ResumeResponse response = new ResumeResponse(feedback);
		
		return new ResponseEntity<>(new ApiResponse<>("Review Successfully completed", response),HttpStatus.OK) ;
	}
}
