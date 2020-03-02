package io.novelis.demo.dto;

public class ErrorResponse extends AppResponse {
	
	 public ErrorResponse(String errorMessage) {
	        super(false);
	        addFullMessage(errorMessage);
	    }
}
