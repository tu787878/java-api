package me.halotu.mapper;

import com.google.gson.JsonElement;

public class StandardResponse {
	private String status;
    private String message;
    private JsonElement data;

    public StandardResponse(String status) {
    	this.status = status;
    }
    public StandardResponse(String status, String message) {
    	this.status = status;
    	this.message = message;
    }
    public StandardResponse(String status, JsonElement data) {
    	this.status = status;
    	this.data = data;
    }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JsonElement getData() {
		return data;
	}
	public void setData(JsonElement data) {
		this.data = data;
	}
    
    
}
