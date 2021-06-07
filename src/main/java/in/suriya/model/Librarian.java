package in.suriya.model;

public class Librarian {
	
	private String userName;
    private String password;
    
    public Librarian(String userName,String password) {
    	this.userName=userName;
    	this.password=password;
     }
    
    
    public String getUserName() {
	    return userName;
	}
	
	
	public String getPassword() {
		return password;
	
	}
       
}
