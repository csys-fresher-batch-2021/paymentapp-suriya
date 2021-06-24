package in.suriya.model;

public class Fee {
	private long rollNo;
	private String firstGraduateRequest="Not-Applied";
	private String scholarshipRequest="Not-Applied";
	private String govtSchemesRequest="Not-Applied";
	private String busRequest="Not-Applied";
	
	@Override
	public String toString() {
		return "Fee [rollNo=" + rollNo + ", firstGraduateRequest=" + firstGraduateRequest + ", scholarshipRequest="
				+ scholarshipRequest + ", govtSchemesRequest=" + govtSchemesRequest + ", busRequest=" + busRequest
				+ "]";
	}
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstGraduateRequest() {
		return firstGraduateRequest;
	}
	public void setFirstGraduateRequest(String firstGraduateRequest) {
		this.firstGraduateRequest = firstGraduateRequest;
	}
	public String getScholarshipRequest() {
		return scholarshipRequest;
	}
	public void setScholarshipRequest(String scholarshipRequest) {
		this.scholarshipRequest = scholarshipRequest;
	}
	public String getGovtSchemesRequest() {
		return govtSchemesRequest;
	}
	public void setGovtSchemesRequest(String govtSchemesRequest) {
		this.govtSchemesRequest = govtSchemesRequest;
	}
	public String getBusRequest() {
		return busRequest;
	}
	public void setBusRequest(String busRequest) {
		this.busRequest = busRequest;
	}
}
