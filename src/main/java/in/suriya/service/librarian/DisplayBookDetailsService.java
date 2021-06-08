package in.suriya.service.librarian;

import java.sql.SQLException;
import java.util.List;

import in.suriya.dao.BookDAO;
import in.suriya.model.Book;
import in.suriya.model.EnrolledBook;

public class DisplayBookDetailsService {
	
	BookDAO bookDao=new BookDAO();
	/**
	 * get book list in library
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	 public List<Book> displayBookList() throws ClassNotFoundException, SQLException{
	    	return bookDao.getBookDetails();
	    }
	 
	 
	 
	 /**
	  * get enrolled book list
	  * 
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 
	 public List<EnrolledBook> displayEnrolledBookList() throws ClassNotFoundException, SQLException{
	    	return bookDao.getEnrolledBookDetails();
	    }
	    

}
