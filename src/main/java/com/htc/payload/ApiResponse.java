package com.htc.payload;

/**
 * Created by Birame BA on 11/09/19.
 */
public class ApiResponse {
    private Boolean success;
    private String message;
   
	public ApiResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
		
	}
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    
}
