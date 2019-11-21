package edu.mum.mail.model;

public class PersonType {
    
	private int personTypeId;
	private String type;
   
      
    public PersonType() {
    }
    
    public PersonType(String type) {
    	
    	this.type = type;
    	
    }

    
    public PersonType(int personTypeId, String type) {
    	this.personTypeId=personTypeId;
    	this.type = type;
    	
    }

    
	

	

	public int getPersonTypeId() {
		return personTypeId;
	}







	public void setPersonTypeId(int personTypeId) {
		this.personTypeId = personTypeId;
	}







	public String getType() {
		return type;
	}







	public void setType(String type) {
		this.type = type;
	}



}
