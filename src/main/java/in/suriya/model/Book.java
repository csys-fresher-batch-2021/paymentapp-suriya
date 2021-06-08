package in.suriya.model;

public class Book {
    private int bookId;
    private String bookName;
    private int quantity;
    
    public Book(int bookId,String bookName,int quantity) {
    	this.bookId=bookId;
    	this.bookName=bookName;
    	this.quantity=quantity;
    	
    	
    }
    public int getBookId() {
		return bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
    
    
    
    
    
}
