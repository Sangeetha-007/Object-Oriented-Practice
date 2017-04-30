//Sangeetha Sasikumar
import java.time.*;

public abstract class LibraryMaterialCopy extends LibraryMaterial {
	protected LibraryCard card;
	protected LocalDate duedate;
	protected Book book;  
	protected DVD dvd;
	
	
	public abstract LibraryMaterial getLibraryMaterial(); //no body 
	public abstract double getFinePerDay(); 

	public abstract int getBorrowingPeriod();

	LibraryMaterialCopy (Book b, DVD d){    //constructor
		super();
		book=b;
		dvd=d;
		duedate=null;
		card=null;
	
	
	}
	
	public void print(){
		System.out.println("Cardholder:" + card.getCardholderName());
		System.out.println("Due on:"+ duedate);
	}
	
	public abstract boolean checkOut(LibraryCard borrower, LocalDate dateOfBorrowing);
	public abstract boolean checkOut(LibraryCard borrower);
	public abstract boolean returnMaterial();
}
