package in.suriya.service.student;

import java.util.List;

import in.suriya.dao.StudentDAO;
import in.suriya.model.Student;
import in.suriya.util.Validation;

public class StudentPaymentService {
	StudentDAO studentDao=new StudentDAO();
	/**
	 * fee structure update is done here  
	 * @param rollNo
	 * @param feeStructure
	 * @return
	 * @throws Exception
	 */
	public boolean feeStructureUpdate(long rollNo,int feeStructure) throws Exception {
		boolean isUpdate=false;
		int fee=studentDao.getFee(rollNo);
		if(fee==0)throw new Exception("Fee already paid");
		if(fee%feeStructure!=0)throw new Exception("Fee Structure "+feeStructure+" is not applicable" );
		isUpdate=studentDao.feeStructureUpdate(rollNo,feeStructure);
	  return isUpdate;	
	}
	/**
	 * payment update done in this method
	 * @param fee
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	public boolean payment(int fee,String rollNo) throws Exception {
		boolean billDetails=false;
		String paymentDetails=null;
		int fees=0;
		int feeStructure=0;
		long rollNum=Long.parseLong(rollNo);
		Validation.feeValidater(fee);
		List<Student> studentList=studentDao.getFeeStudent(rollNum);
	    for(Student studList:studentList) {
	    	feeStructure=studList.getFeeStructure();
	    	fees=studList.getFee();
	    }
		if(fees==0)throw new Exception("Already paid");			
		if(fees/feeStructure!=fee)throw new Exception("Enter Correct Payment//payment to pay:"+fees/feeStructure);
		fees=(fees-fee);//reduce amount
	     if(fees==0){
	          paymentDetails="SUCCESS";
   	     }else {
	    	 paymentDetails="PENDING";
		   }
		 Student stud=new Student(rollNum,feeStructure,fees,paymentDetails);
		 billDetails=studentDao.updatePayment(stud);
		return billDetails;
	}
}
