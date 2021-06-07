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
       
       
       
       public Student(long rollNo,long MobNo) {
    	   this.rollNo=rollNo;
    	   this.mobNo=MobNo;
      }
       
      
      public Student(long rollNo,long MobNo,int fee) {
    	   this.rollNo=rollNo;
    	   this.mobNo=MobNo;
    	   this.fee=fee;
      }
      
      public Student(long rollNo,int fee,String paymentStatus) {
   	      this.rollNo=rollNo;
   	      this.fee=fee;
   	      this.paymentDetails=paymentStatus;

     }
     
      
      public Student(long rollNo,long MobNo,int fee,String paymentStatus) {
    	  this.rollNo=rollNo;
   	      this.mobNo=MobNo;
   	      this.fee=fee;
   	      this.paymentDetails=paymentStatus;
     }
      
      
      
      
    public long getRollNo() {
		return rollNo;
	}
	

	public long getMobNo() {
		return mobNo;
	}


	public int getFee() {
		return fee;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}


	
       
      
}
