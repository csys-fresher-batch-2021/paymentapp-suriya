package in.suriya.model;

public class Student {
	
	 private String name;
	 private long rollNo;
	 private long mobNo;
	 private String location;
	 private int feeStructure;
     private int fee;
     private String paymentDetails="Not-Paid";
	
	 /**
	  * print to string 
	  *   
	  */
     @Override
 	public String toString() {
 		return "Student [name=" + name + ", rollNo=" + rollNo + ", mobNo=" + mobNo + ", feeStructure=" + feeStructure
 				+ ", fee=" + fee + ", paymentDetails=" + paymentDetails + "]";
 	}
       
     public Student(String name,long rollNo,long mobNo,int fee,String location) {
       this.name=name;
  	   this.rollNo=rollNo;
  	   this.mobNo=mobNo;
  	   this.fee=fee;
  	   this.location=location;
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
      
    public String getName() {
    	return name;
    }  
      
    public long getRollNo() {
		return rollNo;
	}
	

	public long getMobNo() {
		return mobNo;
	}
	
	public String getLocation() {
		return location;
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
