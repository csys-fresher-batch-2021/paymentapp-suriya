package in.suriya.model;

public class Student {
	 private long rollNo;
	 private long mobNo;
	 private int feeStructure;
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
       
       
       
       public Student(long rollNo,long mobNo) {
    	   this.rollNo=rollNo;
    	   this.mobNo=mobNo;
      }
       
      
      public Student(long rollNo,long mobNo,int fee) {
    	   this.rollNo=rollNo;
    	   this.mobNo=mobNo;
    	   this.fee=fee;
      }
      
      public Student(long rollNo,int fee,String paymentStatus) {
   	      this.rollNo=rollNo;
   	      this.fee=fee;
   	      this.paymentDetails=paymentStatus;

     }
      
      public Student(long rollNo,int feeStructure,int fee,String paymentStatus) {
   	      this.rollNo=rollNo;
   	      this.fee=fee;
   	      this.paymentDetails=paymentStatus;

     }
     
      
      public Student(long rollNo,long mobNo,int fee,String paymentStatus) {
    	  this.rollNo=rollNo;
   	      this.mobNo=mobNo;
   	      this.fee=fee;
   	      this.paymentDetails=paymentStatus;
     }
      
      public Student(long rollNo,long mobNo,int feeStructure,int fee,String paymentStatus) {
    	  this.rollNo=rollNo;
   	      this.mobNo=mobNo;
   	      this.feeStructure=feeStructure;
   	      this.fee=fee;
   	      this.paymentDetails=paymentStatus;
     }
      public Student(int feeStructure,int fee) {
    	  this.feeStructure=feeStructure;
    	  this.fee=fee;
      }
      
      
      
    public long getRollNo() {
		return rollNo;
	}
	

	public long getMobNo() {
		return mobNo;
	}
	
	public int getFeeStructure() {
		return feeStructure;
	}


	public int getFee() {
		return fee;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}


	
       
      
}
