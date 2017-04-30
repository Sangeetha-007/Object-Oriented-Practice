// Sample solution for HW2
import java.time.LocalDate;

public class BookCopy extends LibraryMaterialCopy {
	public static final int BORROWING_WEEKS = 3;
	public static final int RENEWAL_WEEKS = 2;
	public static final double FINE_PER_DAY = .10;
	
	//Sangeetha Sasikumar
	
	public BookCopy(Book b)
	{
		super(b, null); //referring to constructor
	}

	public LibraryMaterial getLibraryMaterial(){return book;}
	public double getFinePerDay(){return FINE_PER_DAY;}
	public Book getBook() {return book;}
	public String getTitle() {return book.getTitle();}
	public LibraryCard getCard() {return card;}
	public LocalDate getDueDate() {return duedate;}
	public String getAuthor(){return book.getAuthor();}
	public String getISBN(){return book.getIsbn();}
	public int getBorrowingPeriod(){return BORROWING_WEEKS;}
	
	public void print(){
		System.out.println("Title:" + getTitle());
		System.out.println("Author:" + getAuthor());
		System.out.println("ISBN:" + getISBN());
		super.print();
		
	}
	
	public boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	/*checks book out by setting card reference to borrower.
	returns false if book is already checked out
	sets due date to BORROWING_WEEKS after current date passed */
	
	{
		if (card != null)
			return false;
		card = borrower;
		duedate = dateOfBorrowing.plusWeeks(BORROWING_WEEKS);
		return true;
	}
	
	public boolean checkOut (LibraryCard borrower)
	//default check out method that uses todays' date
	{
		return checkOut(borrower, LocalDate.now());
	}
	
	public boolean returnMaterial()
			//returns book by removing card reference
			//returns false if there is no reference to a card
	{
		if (card == null)
			return false;
		card = null;
		return true;
	}
	
	public boolean renew (LocalDate renewalDate)
	//renews book using RENEWAL_WEEKS as interval
	//returns false if books is not checked out
	{
		if (card == null)
			return false;
		duedate = renewalDate.plusWeeks(RENEWAL_WEEKS);
		return true;
	}
	
	public boolean renew ()
	//default method uses todays date as renewal date
	{
		return renew(LocalDate.now());
	}
	

}
