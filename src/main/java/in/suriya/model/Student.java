package in.suriya.model;

public class Student {
	 private long rollNo;
	 private long mobNo;
     private int fee;
     private String paymentDetails="Not-Paid";
	
	 /**
	  * print to string 
	  *   
	  */
       @Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", mobNo=" + mobNo + ", fee=" + fee + ", paymentDetails=" + paymentDetails
				+ "]";
	}
       
      
      public Student(long rollNo,long MobNo,int fee) {
    	   this.setRollNo(rollNo);
    	   this.setMobNo(MobNo);
    	   this.setFee(fee);
      }
      
      
      
      public Student(long rollNo,long MobNo,int fee,String paymentStatus) {
   	   this.setRollNo(rollNo);
   	   this.setMobNo(MobNo);
   	   this.setFee(fee);
   	   this.setPaymentDetails(paymentStatus);
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

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	
       
      
}
