package org.zyj.framework.cache.exception;

public class ErrorMessage {

	private String code;
	
	private String summary;
	
	private String detail;
	
	public ErrorMessage() {
	}

	public ErrorMessage(String code) {
		this.code = code;
	}

	public ErrorMessage(String code, String summary) {
		this.code = code;
		this.summary = summary;
	}

	public ErrorMessage(String code, String summary, String detail) {
		this.code = code;
		this.summary = summary;
		this.detail = detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
