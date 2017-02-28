import java.util.ArrayList;  //vector
import java.time.*;


public class LibraryCard {
    private String id;   
    private String cardholderName;
    private ArrayList<BookCopy> booksCheckedOut;
    private double balance;
    
    public LibraryCard(String i, String name)
    {
        id = i;
        cardholderName = name;
        booksCheckedOut = new ArrayList<BookCopy>();
        balance=0;
    }
    
    public String getID() {return id;}
    public String getCardholderName() {return cardholderName;}
    public ArrayList<BookCopy> getBooksCheckedOut() {return booksCheckedOut;}  //getter returning an array
    
    public double getBalance() {
        return balance;
    }
    public void addToBalance(double a){
    		balance+=a;
    		
    }
    
    
    public void renew(BookCopy bc){
    	LocalDate TwoWeeksLater = bc.getDueDate().plusWeeks(2);
    	bc.setDueDate(TwoWeekslater);
    	
    }
    //public void setBalance(double balance) {
      //  this.balance = balance;
    }
    public void setCardholderName (String name) {cardholderName = name;}
    
    public boolean checkOutBook (BookCopy book)
    //checks out book and sends message to BookCopy to check itself out too
    //returns false if book is already checked out
    {
        if (!book.checkOut(this))
            return false;
        booksCheckedOut.add(book);
        return true;
    }
    
    public boolean returnBook (BookCopy book)
    //returns book and sends message to BookCopy to do the same
    //returns false if book is not checked out
    {
        if (!book.returnBook())
            return false;
        if (!booksCheckedOut.remove(book))   //if it did remove it returns true (its a boolean)
            return false;
        return true;
    }
}
