package es.secaro.thymeleafdemo.dto;

public class Response {
    private int ResponseID;
    private Question question;
    private String ResponseValue;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response(int responseID, Question question, String responseValue, String status) {
        ResponseID = responseID;
        this.question = question;
        ResponseValue = responseValue;
        this.status = status;
    }

    public int getResponseID() {
        return ResponseID;
    }

    public void setResponseID(int responseID) {
        ResponseID = responseID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getResponseValue() {
        return ResponseValue;
    }

    public void setResponseValue(String responseValue) {
        ResponseValue = responseValue;
    }
}

