package in.suriya.model;


public class EnrolledBook {
	private int bookId;
    private String bookName;
    private long rollNo;
    private long mobNo;
    private String enrolledDate;
    
    
   public EnrolledBook(int bookId,String bookName,String enrolledDate) {
    	
    	this.bookId=bookId;
    	this.bookName=bookName;
    	this.enrolledDate=enrolledDate;
    }
 
    
    public EnrolledBook(int bookId,String bookName,long rollNo,long mobNo,String enrolledDate) {
    	
    	this.bookId=bookId;
    	this.bookName=bookName;
    	this.rollNo=rollNo;
    	this.mobNo=mobNo;
    	this.enrolledDate=enrolledDate;
    }
    public int getBookId() {
		return bookId;
	}
    
	public String getBookName() {
		return bookName;
	}
	
	public long getRollNo() {
		return rollNo;
	}
	
	public long getMobNo() {
		return mobNo;
	}
	
	public String getEnrolledDate() {
		return enrolledDate;
	}
	
	
	
	
}
