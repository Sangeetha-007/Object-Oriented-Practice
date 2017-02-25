import java.util.ArrayList;

public class LibraryCard {
	private String id;
	private String cardholderName;
	private ArrayList<BookCopy> booksCheckedOut;
	
	public LibraryCard(String i, String name)
	{
		id = i;
		cardholderName = name;
		booksCheckedOut = new ArrayList<BookCopy>();
	}
	
	public String getID() {return id;}
	public String getCardholderName() {return cardholderName;}
	public ArrayList<BookCopy> getBooksCheckedOut() {return booksCheckedOut;}
	
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
		if (!booksCheckedOut.remove(book))
			return false;
		return true;
	}

}
