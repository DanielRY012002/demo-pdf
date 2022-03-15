package es.secaro.thymeleafdemo.dto;

public class Table01 {
	private String row1;
	private String row2;
	public Table01(String row1, String row2) {
		this.row1 = row1;
		this.row2 = row2;
	}
	public String getRow1() {
		return row1;
	}
	public void setRow1(String row1) {
		this.row1 = row1;
	}
	public String getRow2() {
		return row2;
	}
	public void setRow2(String row2) {
		this.row2 = row2;
	}
}
