package in.suriya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.suriya.model.Book;
import in.suriya.model.EnrolledBook;
import in.suriya.model.Staff;
import in.suriya.util.ConnectionUtil;

public class BookDAO{
	/**
	 * enroll book in database
	 * @param bookId
	 * @param rollNo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean enrollBook(int bookId,long rollNo)throws ClassNotFoundException,SQLException{
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		   connection=ConnectionUtil.getConnection();
		   String sql="insert into enrolled_book(book_id,book_name,roll_no,mob_no)  select l.book_id,l.book_name,s.roll_no,s.mob_no from student s,library l where s.roll_no=? and l.book_id=? and ? not in(select (roll_no) from enrolled_book where roll_no=? and book_id=?)";
		   pst=connection.prepareStatement(sql);
		   pst.setLong(1,rollNo);
		   pst.setLong(2,bookId);
		   pst.setLong(3,rollNo);
		   pst.setLong(4,rollNo);
		   pst.setLong(5,bookId);
           int rows=pst.executeUpdate();
		   if(rows==1){
		      isSave=true;}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally {
		        ConnectionUtil.close(connection,pst);
		}
	 return isSave;
	}
	/**
	 * detele entry from 
	 * @param rollno
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean deleteErolledBook(int bookId,long rollNo)throws ClassNotFoundException,SQLException{
		boolean isSave=false;
		Connection connection=null;
		PreparedStatement pst=null;
		try {
		    connection=ConnectionUtil.getConnection();
		    String sql="delete from enrolled_book where book_id=? and roll_no=?";
		    pst=connection.prepareStatement(sql);
		    pst.setInt(1,bookId);
		    pst.setLong(2,rollNo);
		    int rows=pst.executeUpdate();
		    if(rows==1){
		       isSave=true;}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(connection,pst);}
	 return isSave;
	}
	/** 
	 * decrease quantity  in database 
	 * @param bookId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	 public boolean updateEnrollQuantity(int bookId)throws ClassNotFoundException,SQLException{
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();
			   String sql="update library set quantity=quantity-1 where book_id=?";
			   pst=connection.prepareStatement(sql);
			   pst.setLong(1,bookId);
			   int rows=pst.executeUpdate();
		       if(rows==1){
			       isUpdate=true;}
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			}finally{
			        ConnectionUtil.close(connection,pst);}
		return isUpdate;
	  }
	 /**
	  * increases book quantity in database 
	  * @param bookId
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public boolean cancelEnrollQuantity(int bookId)throws ClassNotFoundException,SQLException{
	    	boolean isUpdate=false;
	    	Connection connection=null;
			PreparedStatement pst=null;
			try {
			   connection=ConnectionUtil.getConnection();
			   String sql="update library set quantity=quantity+1 where book_id=?";
			   pst=connection.prepareStatement(sql);
			   pst.setLong(1,bookId);
			   int rows=pst.executeUpdate();
		       if(rows==1){
			       isUpdate=true;}
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			}finally {
			        ConnectionUtil.close(connection,pst);}
		 return isUpdate;
	    }
	 /**
	  * get list of enrolled book 
	  * @param rollNo
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public List<EnrolledBook> getPersonalEnrolledBookDetails(long rollNo)throws ClassNotFoundException,SQLException{
		    List<EnrolledBook> enrolledBookList=new ArrayList<>();
			Connection connection=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try {
			    connection=ConnectionUtil.getConnection();
			    String sql="select book_id,book_name,enrolled_date from enrolled_book where roll_no=?";  
                pst=connection.prepareStatement(sql);
			    pst.setLong(1,rollNo);
			    rs =pst.executeQuery();
	            while(rs.next()){
	                 int bookId=rs.getInt("book_id");
	                 String bookName=rs.getString("book_name");
	                 String enrolledDate=rs.getString("enrolled_date");
	                 EnrolledBook enrolledBook=new EnrolledBook(bookId,bookName,enrolledDate);
	    		     enrolledBookList.add(enrolledBook);}
	          }catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			 }finally{
				ConnectionUtil.close(connection,pst,rs);
			}
	 return enrolledBookList;
	}
/**
 *  fetching  enrolled book details from database 
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	 public List<EnrolledBook> getEnrolledBookDetails()throws ClassNotFoundException,SQLException{
		    List<EnrolledBook> enrolledBookList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			     connection=ConnectionUtil.getConnection();
				 String sql="select book_id,book_name,roll_no,mob_no,enrolled_date from enrolled_book order by book_id";
                 st=connection.createStatement();
                 rs =st.executeQuery(sql);
	             while(rs.next()){
	                int bookId=rs.getInt("book_id");
	                String bookName=rs.getString("book_name");
	                long rollNo=rs.getLong("roll_no");
	                long mobNo=rs.getLong("mob_no");
	                String enrolledDate=rs.getString("enrolled_date");
	                EnrolledBook enrolledBook=new EnrolledBook(bookId,bookName,rollNo,mobNo,enrolledDate);
	    			enrolledBookList.add(enrolledBook);	 
	            }
	         }catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			 }finally{
				ConnectionUtil.close(connection,st,rs);
			}
	     return enrolledBookList;
		}
	 /** 
	  * fetching book details from database
	  * @return
	  * @throws ClassNotFoundException
	  * @throws SQLException
	  */
	 public List<Book> getBookDetails()throws ClassNotFoundException,SQLException{
		    List<Book> bookList=new ArrayList<>();
			Connection connection=null;
			Statement st=null;
			ResultSet rs=null;
			try {
			    connection=ConnectionUtil.getConnection();
				String sql="select book_id,book_name,quantity from library order by book_id";
                st=connection.createStatement();
                rs =st.executeQuery(sql);
	            while(rs.next()){
	                int bookId=rs.getInt("book_id");
	                String bookName=rs.getString("book_name");
	                int quantity=rs.getInt("quantity");
	                Book book=new Book(bookId,bookName,quantity);
	    			bookList.add(book);
	            }
	        }catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
			}finally{
				ConnectionUtil.close(connection,st,rs);
			}
	 return bookList;
	}
}
