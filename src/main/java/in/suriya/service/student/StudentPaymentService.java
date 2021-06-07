package in.suriya.service.student;

import in.suriya.dao.StudentDAO;
import in.suriya.model.Student;
import in.suriya.util.Validation;

public class StudentPaymentService {
	
	public static boolean payment(int fee,String rollNo) throws Exception {
		boolean billDetails=false;
		String paymentDetails=null;
		long rollNum=Long.parseLong(rollNo);
		
		Validation.feeValidater(fee);
			
		int fees=StudentDAO.getFee(rollNum);
		
		if(fees==0)throw new Exception("Already paid");
			
			
		if(fees<fee) throw new Exception("Enter Correct Payment//payment to pay:"+fees);
		
		fees=(fees-fee);//reduce amount
	     if(fees==0){
	          paymentDetails="SUCCESS";
   	     }else {
	    	 paymentDetails="PENDING";
		   }
		 Student stud=new Student(rollNum,fees,paymentDetails);
		 
		 billDetails=StudentDAO.updatePayment(stud);

		return billDetails;
	}
	

}
