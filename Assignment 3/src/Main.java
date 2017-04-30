import java.util. *;
import java.time.*;
import java.time.temporal.ChronoUnit;


public class Main {
	public static void main(String[] args){

		Book book1 = new Book("1234567","Snow In August", "Pete Hamill" );
		Book book2 = new Book("9876543", "To Kill A Mockingbird", "Harper Lee");
		Book book3 = new Book("2345678", "Lord of the Flies", "William Golding");

		BookCopy copy1a = new BookCopy(book1);
		BookCopy copy1b = new BookCopy(book1);
        BookCopy copy2a = new BookCopy(book2);
		BookCopy copy2b = new BookCopy(book2);
		BookCopy copy3a = new BookCopy(book3);
		BookCopy copy3b = new BookCopy(book3);
		
		DVD dvd1 = new DVD("1212121","Nocturnal Animals", "Jake Gyllenhall");
		DVD dvd2 = new DVD("2323232", "Pirates of the Caribbean","Johnny Depp");
		DVD dvd3 = new DVD("5454545", "Passengers", "Jennifer Lawrence");
		
		DVDCopy dvda = new DVDCopy(dvd1);
		DVDCopy dvdb = new DVDCopy(dvd2);
		DVDCopy dvdc = new DVDCopy(dvd3);
		
		LibraryCard cardA = new LibraryCard("123456789", "Sangeetha Sasikumar");
		LibraryCard cardB = new LibraryCard("987654321", "Devorah Kletenik");
		
		cardA.checkOutMaterial(copy1a, LocalDate.of(2017, 5, 5));
		cardA.checkOutMaterial(copy2a, LocalDate.of(2017, 3, 26));
		cardA.checkOutMaterial(copy3a, LocalDate.of(2016, 12, 31));
		cardA.checkOutMaterial(dvda, LocalDate.of(2017, 5, 20));
		cardA.checkOutMaterial(dvdb, LocalDate.of(2016, 4,20));
		
		// get materials checked out for each card
        ArrayList<LibraryMaterialCopy> materialsCheckedOutA = cardA.getMaterialsCheckedOut();
        ArrayList<LibraryMaterialCopy> materialsCheckedOutB = cardB.getMaterialsCheckedOut();
        
        // print info for each material
        System.out.println(cardA.getCardholderName() + " has " + materialsCheckedOutA.size() + " materials checked out\n");
        for(LibraryMaterialCopy m : materialsCheckedOutA)
        {
        	m.print();  //print is abstract
        	System.out.println();
       	}
        System.out.println();
        System.out.println(cardB.getCardholderName() + " has " + materialsCheckedOutB.size() + " materials checked out\n");
        for(LibraryMaterialCopy m : materialsCheckedOutB)
        {
        	m.print();  //print is abstract
        	System.out.println();
       	}
        	
        LocalDate todaysDate = LocalDate.now();
        
        System.out.println("Returning all overdue materials....\n");
        // return all overdue materials
        ArrayList<LibraryMaterialCopy> overdueMaterials = cardA.getMaterialsOverdue(todaysDate);
        for(LibraryMaterialCopy m : overdueMaterials)
        	cardA.returnMaterial(m);
        
      
        
        System.out.println("All materials returned");
        
    }

		
}


