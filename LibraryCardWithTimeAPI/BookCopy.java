// Sample solution for HW1
public class BookCopy {
	private Book book;
	private LibraryCard card;
	
	public BookCopy(Book b)
	{
		book = b;
		card = null;
	}
	
	public Book getBook() {return book;}
	public LibraryCard getCard() {return card;}
	
	public boolean checkOut(LibraryCard borrower)
	//checks book out by setting card reference to borrower.
	//returns false if book is already checked out
	{	
		//DueDate weekLater = todaysDate.plusWeeks(3);
		if (card != null)
			return false;
		card = borrower;
		return true;
	}
	public boolean DueDate(    ){
		
		if(checkOut==false)
			return null;
		
	}
	
	public boolean returnBook()
			//returns book by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}

}
