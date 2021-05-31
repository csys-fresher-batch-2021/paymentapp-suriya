package in.suriya.model;

public class Staff {
	 private String name;
	 private long mobNo;
     private String password;
     
     
	@Override
	public String toString() {
		return "Staff [name=" + name + ", mobNo=" + mobNo + ", password=" + password + "]";
	}
	
	

    public Staff(String name,long mobNo,String password){
    	this.setName(name);
    	this.setMobNo(mobNo);
    	this.setPassword(password);
    }

    
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}


	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
     
}
