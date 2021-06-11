package in.suriya.service.student;



import java.util.ArrayList;
import java.util.List;

import in.suriya.dao.FeeDAO;
import in.suriya.dao.StudentDAO;
import in.suriya.model.Fee;

public class StudentScholarshipRequestService {
     
	StudentDAO studentDao=new StudentDAO();
	
	/**
	 * student payment calculation
	 * @param status
	 * @param salary
	 * @param busFee
	 * @param firstGraduate
	 * @param govtSchemes
	 * @param rollNo
	 * @return
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	public boolean studentScholarshipRequest(String scholarshipStatus,int income,String busRoute,int firstGraduate,String govtScheme,String rollNo) throws ClassNotFoundException, Exception {
		boolean feeRequest=false;
		long rollNum=Long.parseLong(rollNo);
		List<Fee> feeList=new ArrayList<>();
		FeeDAO feeDao=new FeeDAO();
		
		
		if(scholarshipStatus.equals("no")&&(firstGraduate==0)&&(govtScheme.equals("none"))&&(busRoute.equals("none")))throw new Exception("your form is rejected//due to lack of details");
		
		Fee fee=new Fee();
		fee.setRollNo(rollNum);
		
		if(scholarshipStatus.equals("yes")) {
			fee.setScholarshipRequest("Applied");
		}
		if(firstGraduate!=0)
		{
			fee.setFirstGraduateRequest("Approved");
		}	
		if(!busRoute.equals("none")) {
			fee.setBusRequest("Applied");
		}
		if(!govtScheme.equals("none")) {
			fee.setGovtSchemesRequest("Applied");
		}
		
		feeList.add(fee);
		feeRequest=feeDao.saveFeeDetails(fee);
		
		
		
		if(scholarshipStatus.equals("yes")) {
			feeDao.saveScholarshipRequest(rollNum,income);
		}
		
		if(!busRoute.equals("none")) {
			feeDao.saveBusRequest(rollNum, busRoute);
		}
		if(!govtScheme.equals("none")) {
			feeDao.saveSchemeRequest(rollNum, govtScheme);
		}
		if(firstGraduate!=0)
		{
			 int fees=studentDao.getFee(rollNum);
			
	    	 fees=fees-(fees*20/100);
	         studentDao.setFee(rollNum, fees);
		}	
		
		
		return feeRequest;
	}
	
	
}
