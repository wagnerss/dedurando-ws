package br.com.dedurando.bean;

public enum StatusType {
	
	INACTIVE(1), ACTIVE(0);
	
	private int status;
 
	private StatusType(int status) {
		this.status = status;
	}
 
	public int getStatus() {
		return status;
	}
	
	 public static StatusType parse(int status) {  
		 StatusType statusType = null;   
	        for (StatusType item : StatusType.values()) {  
	            if (item.getStatus() == status) {  
	            	statusType = item;  
	                break;  
	            }  
	        }  
	        return statusType;  
	    }  
	
}
