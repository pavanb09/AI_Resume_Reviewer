package com.example.resumereviewer.dto;

public class ResumeRequest {
	
	private String resumeText;

	public ResumeRequest(String resumeText) {
		super();
		this.resumeText = resumeText;
	}

	public ResumeRequest() {
		super();
	}

	public String getResumeText() {
		return resumeText;
	}

	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}
	
	

}
