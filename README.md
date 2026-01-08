# 🧠 AI Resume Reviewer

AI Resume Reviewer is a full-stack web application that analyzes resumes and provides structured feedback using AI.  
It helps candidates understand their strengths, weaknesses, and areas of improvement in a clear, readable format.

---

## 🚀 Features

- 📄 Paste resume text and get AI-generated feedback
- 🧩 Structured review format:
  - Overall Summary
  - Strengths
  - Areas for Improvement
  - Score (out of 10)
- ⚡ Fast AI inference using Groq API
- 🔐 Secure API key handling using environment variables
- 🐳 Dockerized backend for easy deployment
- 🌐 REST API integration between frontend and backend

---

## 🛠️ Tech Stack

### Frontend
- React.js
- Axios
- CSS

### Backend
- Java 21
- Spring Boot
- Spring Web (REST APIs)
- Jackson (ObjectMapper)

### AI Integration
- Groq AI API (LLaMA 3.1 model)

### DevOps & Deployment
- Docker (multi-stage build)
- Render (Docker-based deployment)
- GitHub

---

## 📁 Project Structure

AI_Resume_Reviewer/

├── backend/

│ └── ResumeReviewer/

│ ├── Dockerfile

│ ├── pom.xml

│ ├── src/

│ └── application.properties

├── frontend/

│ ├── src/

│ └── package.json

└── README.md


---

## 🔑 Environment Variables

The application uses environment variables to keep sensitive data secure.

### Required Variable

GROQ_API_KEY=your_groq_api_key


### Spring Boot Configuration

properties
groq.api.key=${GROQ_API_KEY}
