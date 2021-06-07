package in.suriya.service.librarian;

import java.sql.SQLException;
import java.util.List;

import in.suriya.dao.BookDAO;
import in.suriya.model.Book;
import in.suriya.model.EnrolledBook;

public class DisplayBookDetailsService {
	
	
	/**
	 * get book list in library
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	 public static List<Book> displayBookList() throws ClassNotFoundException, SQLException{
	    	List<Book> bookList=BookDAO.getBookDetails();
	    	return bookList;
	    }
	 
	 
	 
	 /**
	  * get enrolled book list
	  * 
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 
	 public static List<EnrolledBook> displayEnrolledBookList() throws ClassNotFoundException, SQLException{
	    	List<EnrolledBook> enrolledBookList=BookDAO.getEnrolledBookDetails();
	    	return enrolledBookList;
	    }
	    

}
