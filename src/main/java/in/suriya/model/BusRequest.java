package in.suriya.model;

public class BusRequest {
	private String name;
	private long rollNo;
    private long mobNo;
    private String busRoute;
    private String requestStatus="pending";
    
    
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
	public String getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(String busRoute) {
		this.busRoute = busRoute;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
     @Override
	public String toString() {
		return "BusRequest [name=" + name + ", rollNo=" + rollNo + ", mobNo=" + mobNo + ", busRoute=" + busRoute
				+ ", requestStatus=" + requestStatus + "]";
	}
	
     
     
}
