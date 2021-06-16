package in.suriya.model;

public class SchemeRequest {
	private String name;
	private long rollNo;
    private long mobNo;
	private String location;
    private String scheme;
    private String requestStatus="pending";
    
    
    @Override
	public String toString() {
		return "SchemeRequest [name=" + name + ", rollNo=" + rollNo + ", mobNo=" + mobNo + ", location=" + location
				+ ", scheme=" + scheme + ", requestStatus=" + requestStatus + "]";
	}
	
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}
	
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	

}
