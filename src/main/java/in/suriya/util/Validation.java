package in.suriya.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private Validation() {
		//default constructor
	}

	
	/**
	 * Mobile Number Checker(10-digit number)
	 * 
	 * @param mobNo
	 * @return
	 * @throws Exception 
	 */
	
	public static void mobNoValidater(long mobNo) throws Exception {
		boolean isMobNoValid=false;
		String check = "^[6-9]\\d{9}$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(String.valueOf(mobNo));
		isMobNoValid =m.matches();
		
		if(!isMobNoValid)throw new Exception("Invalid MobileNo Format");
		

	}
	
	
	

	/**
	 * Password Checker-password format((0-9)(a-z)(A-Z)[@#$%])
	 * 
	 * 
	 * @param password
	 * @return
	 */
	
	public static void passwordValidater(String password) throws Exception {
		boolean isPassValid;
		String check = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16}$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(password);
	    isPassValid = m.matches();
	    if(!isPassValid)throw new Exception("Invalid Password Format");
	    
		
	}
	
	
	
	
	/**roll number validater
	 * 
	 * @param rollNo
	 * @return
	 */
	
	public static void rollNoValidater(long rollNo) throws Exception {                                           
			if(String.valueOf(rollNo).length()!=7) throw new Exception("Invalid Roll Number");
				//return isRollNoValid;
	}
	
	
	
	
	
   /**
    * fee validater checks fee lesser than zero or equal to zero
    * 
    * @param fee
    * @throws Exception
    */
	
	public static void feeValidater(int fee)throws Exception {
		if(fee<=0)throw new Exception("Invalid Fee");
	
	}
	
	/**
	 * salary validater 
	 * 
	 * @param salary
	 * @throws Exception
	 */
	public static void salaryValidater(int salary)throws Exception {
		if(salary>500000)throw new Exception("You are not eligible for scholarship ");
	    if(salary<=10000)throw new Exception("Income Starts from 10000");
	}
	
	
	
	/**
	 * parseLong method used to give error message long parse
	 * 
	 * @param input
	 * @param errorMessage
	 * @return
	 * @throws Exception
	 */
	
	public static long parseLong(String input, String errorMessage) throws Exception {
		try {
			return  Long.parseLong(input);
		}
		catch(NumberFormatException e) {
			throw new Exception(errorMessage);
		}
	}
	
	
	/**
	 * parseInt method  used to give error message fot int parse
	 * @param input
	 * @param errorMessage
	 * @return
	 * @throws Exception
	 */
	
	public static int parseInt(String input, String errorMessage) throws Exception {
		try {
			return  Integer.parseInt(input);
		}
		catch(NumberFormatException e) {
			throw new Exception(errorMessage);
		}
	}
	
	
	/**parse string
	 * 
	 * @param input
	 * @param errorMessage
	 * @return
	 * @throws Exception
	 */
	public static void nameValidater(String input,String errorMessage) throws Exception {
		if(input==null||input.trim()==""||input.trim().length()<3)throw new Exception(errorMessage);
		}
	
	
	
	
	
}
