package in.suriya.service.librarian;

import in.suriya.dao.BookDAO;
import in.suriya.util.Validation;

public class BookRegisterService {
	BookDAO bookDao=new BookDAO();
	/**
	 * enroll book in database 
	 * @param bookId
	 * @param rollNo
	 * @return
	 * @throws Exception
	 */
	  public boolean enrollBook(int bookId,long rollNo) throws Exception {
    	boolean valid=false;
    	Validation.rollNoValidater(rollNo);
        valid=bookDao.enrollBook(bookId,rollNo);
        if(valid) {
        	bookDao.updateEnrollQuantity(bookId);
        }
    	return valid;
        }
	  /**
	   * delete book in database
	   * @param bookId
	   * @param rollNo
	   * @return
	   * @throws Exception
	   */
	  public boolean deleteEnrollBook(int bookId,long rollNo) throws Exception {
	    	boolean valid=false;
	    	Validation.rollNoValidater(rollNo);
	        valid=bookDao.deleteErolledBook(bookId,rollNo);
	        if(valid) {
	        	bookDao.cancelEnrollQuantity(bookId);
	        }
	    return valid;
	  }
}
