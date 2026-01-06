package com.example.resumereviewer.dto;

public class ResumeResponse {
	
	private String feedback;

	public ResumeResponse(String feedback) {
		super();
		this.feedback = feedback;
	}

	public ResumeResponse() {
		super();
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	

}
