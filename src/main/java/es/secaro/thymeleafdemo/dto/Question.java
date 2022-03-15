package es.secaro.thymeleafdemo.dto;

public class Question {
	private int QuestionID;
	private String QuestionText;

	public Question(int questionID, String questionText) {
		QuestionID = questionID;
		QuestionText = questionText;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}

	public String getQuestionText() {
		return QuestionText;
	}

	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}

}


