import java.time.*;
import java.util.*;

// Sample solution for HW1
public class BookCopy {
	private Book book;
	private LibraryCard card;
	private LocalDate DueDate;
	
	public BookCopy(Book b)
	{
		book = b;
		card = null;
		DueDate=null;
	}
	
	public Book getBook() {return book;}
	public LibraryCard getCard() {return card;}
	

    public LocalDate getDueDate() {
        return DueDate;
    }
    public void setDueDate(LocalDate a) {
          DueDate=a;
    }
    
  
	public boolean checkOut(LibraryCard borrower)
	//checks book out by setting card reference to borrower.
	//returns false if book is already checked out
	{	
		//DueDate weekLater = todaysDate.plusWeeks(3);
		if (card != null)
			return false;
		DueDate=LocalDate.now().plusWeeks(3);  //now is a static method of the LocalDate class
		card = borrower;
		return true;
	}
	
	
	
	
	public boolean returnBook()
			//returns book by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		if( this.getDueDate().getYear() == LocalDate.now().getYear() )
		else if (this.DueDate().getDayOfYear()< LocalDate.now().getDayOfYear() )
			{
				int numDays = LocalDate.now().getDayOfYear() - this.DueDate().getDayOfYear()+ LocalDate.now().getDayOfYear();
				card.addToBalance(numDays * 0.10); 
			}
				
		card = null;
		return true;
	}

}
