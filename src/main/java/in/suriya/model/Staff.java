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
    	this.name=name;
    	this.mobNo=mobNo;
    	this.password=password;
    }
    public Staff(long mobNo,String password){	
    	this.mobNo=mobNo;
    	this.password=password;
    }
    public String getName() {
		return name;
	}
	public long getMobNo() {
		return mobNo;
	}
	public String getPassword() {
		return password;
	}
}
