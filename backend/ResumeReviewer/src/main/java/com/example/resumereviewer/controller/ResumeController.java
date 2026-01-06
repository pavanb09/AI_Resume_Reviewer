package com.example.resumereviewer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.resumereviewer.dto.ApiResponse;
import com.example.resumereviewer.dto.ResumeRequest;
import com.example.resumereviewer.dto.ResumeResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ResumeController {


	
	@PostMapping("/review")
	public ApiResponse<ResumeResponse> reviewResume(@RequestBody ResumeRequest resume){
		
//		System.out.println(resume.getResumeText());
		
		String dummy = "Overall Feedback:\r\n"
				+ "Your resume shows a solid foundation in backend development with Java and Spring Boot.\r\n"
				+ "\r\n"
				+ "Strengths:\r\n"
				+ "- Strong understanding of Core Java concepts\r\n"
				+ "- Hands-on experience with Spring Boot and REST APIs\r\n"
				+ "- Practical project experience in full-stack development\r\n"
				+ "\r\n"
				+ "Areas for Improvement:\r\n"
				+ "- Add measurable achievements (e.g., performance improvements, numbers)\r\n"
				+ "- Include deployment and DevOps exposure\r\n"
				+ "- Improve resume formatting and consistency\r\n"
				+ "\r\n"
				+ "Overall Score: 7.5 / 10\r\n"
				+ "";
		
		ResumeResponse response = new ResumeResponse(dummy);
		
		return new ApiResponse<>("Review Successfully completed", response) ;
	}
}
