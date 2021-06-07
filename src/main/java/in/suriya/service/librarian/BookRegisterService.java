package in.suriya.service.librarian;

import in.suriya.dao.BookDAO;
import in.suriya.util.Validation;

public class BookRegisterService {
	
	
	/**
	 * enroll book in database
	 * 
	 * @param bookId
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	  public static boolean enrollBook(int bookId,long rollNo) throws Exception {
    	boolean valid=false;
    	Validation.rollNoValidater(rollNo);
        valid=BookDAO.enrollBook(bookId,rollNo);
        if(valid) {
        	BookDAO.updateEnrollQuantity(bookId);
        }
    	return valid;
        
        }
	  
	  
	  /**
	   * delete book in database
	   * 
	   * @param bookId
	   * @param rollNo
	   * @return
	   * @throws Exception
	   */
	  public static boolean deleteEnrollBook(int bookId,long rollNo) throws Exception {
	    	boolean valid=false;
	    	Validation.rollNoValidater(rollNo);
	        valid=BookDAO.deleteErolledBook(bookId,rollNo);
	        if(valid) {
	        	BookDAO.cancelEnrollQuantity(bookId);
	        }
	    	return valid;
	        
	        }
   
}
