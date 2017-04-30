//Sangeetha Sasikumar
import java.time.LocalDate;


public class DVDCopy extends LibraryMaterialCopy {
	public static final double FINE_PER_DAY = 1.00;
	public static final int BORROWING_WEEKS = 2;
	public LibraryCard getCard(){return card;}
	public LocalDate getDueDate(){return duedate;}
	
	public int getBorrowingPeriod(){return BORROWING_WEEKS;}
	
	public double getFinePerDay(){return FINE_PER_DAY;}
	
	public LibraryMaterial getLibraryMaterial(){return dvd;}
	public String getTitle(){return dvd.getTitle();}
	public String getISBN(){return dvd.getIsbn();}
	public String getMainActor(){return dvd.getActor();}
	
	public DVDCopy(DVD d){
		super(null,d);
	}

	
	public boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing)
	
	{
		if (card != null)
			return false;
		card = borrower;
		duedate = dateOfBorrowing.plusWeeks(BORROWING_WEEKS);
		return true;
	}

	public boolean checkOut(LibraryCard borrower){
			return checkOut(borrower, LocalDate.now());
	}
	public boolean returnMaterial(){
		if(card==null)
			return false;
		card=null;
		return true;
	}
	public void print(){
		System.out.println("Title: "+ getTitle());
		System.out.println("Main Cast:" + getMainActor());
		System.out.println("ISBN: " + getISBN());
		super.print(); /*if it was a call to a constructor, super would
		     to be put before*/
	}
}
