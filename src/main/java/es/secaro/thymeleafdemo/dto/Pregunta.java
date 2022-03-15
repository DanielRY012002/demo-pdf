package es.secaro.thymeleafdemo.dto;

public class Pregunta {
	private String question;
	private String answer;
	public Pregunta() {
		super();
	}
	public Pregunta(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
