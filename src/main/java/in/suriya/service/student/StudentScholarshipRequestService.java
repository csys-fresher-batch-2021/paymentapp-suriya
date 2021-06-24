package in.suriya.service.student;

import java.util.ArrayList;
import java.util.List;

import in.suriya.dao.FeeDAO;
import in.suriya.dao.StudentDAO;
import in.suriya.model.Fee;

public class StudentScholarshipRequestService {
	StudentDAO studentDao=new StudentDAO();
	/**
	 * update bus request
	 * @param busRoute
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	public boolean studentBusRequest(String busRoute,String rollNo) throws Exception {
		boolean busUpdate=false;
		String requestStatus="Applied";
		long rollNum=Long.parseLong(rollNo);
		FeeDAO feeDao=new FeeDAO();
		if(busRoute.equals("none"))throw new Exception("Select bus Route");
		feeDao.saveBusRequest(rollNum, busRoute);
	    busUpdate=feeDao.busRequestUpdate(rollNum,requestStatus);
	return busUpdate;
	}
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
		if(scholarshipStatus.equals("no")&&(firstGraduate==0)&&(govtScheme.equals("none")))throw new Exception("your form is rejected//due to lack of details");
		Fee fee=new Fee();
		fee.setRollNo(rollNum);
		if(scholarshipStatus.equals("yes")) {
			fee.setScholarshipRequest("Applied");
		}
		if(firstGraduate!=0)
		{
			fee.setFirstGraduateRequest("Approved");
		}	
		if(!govtScheme.equals("none")) {
			fee.setGovtSchemesRequest("Applied");
		}
		feeList.add(fee);
		feeRequest=feeDao.saveFeeDetails(fee);
		if(scholarshipStatus.equals("yes")) {
			feeDao.saveScholarshipRequest(rollNum,income);
		}
		if(!govtScheme.equals("none")) {
			feeDao.saveSchemeRequest(rollNum, govtScheme);
		}
		if(firstGraduate!=0){
			int fees=studentDao.getFee(rollNum);
			if(fees!=0){
	    	 fees=fees-(fees*20/100);
	         studentDao.setFee(rollNum, fees);
	         }
		}	
	  return feeRequest;
	}	
}
