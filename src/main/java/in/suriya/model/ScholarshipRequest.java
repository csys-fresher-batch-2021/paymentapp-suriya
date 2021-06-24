package in.suriya.model;

public class ScholarshipRequest {
   private String name;
    private long rollNo;
    private long mobNo;
    private int income;
    private String requestStatus="pending";
     
    @Override
   	public String toString() {
   		return "ScholarshipRequest [name=" + name + ", rollNo=" + rollNo + ", mobNo=" + mobNo + ", income=" + income
   				+ ", requestStatus=" + requestStatus + "]";
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
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
}
