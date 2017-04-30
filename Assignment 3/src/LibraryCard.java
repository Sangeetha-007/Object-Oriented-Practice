
//Sangeetha Sasikumar

import java.util.ArrayList;
import java.time.LocalDate;
import 	java.time.temporal.ChronoUnit;

public class LibraryCard {
	
	private String id;
	private String cardholderName;
	private ArrayList<LibraryMaterialCopy> materials;
	private double balance;
	
	public LibraryCard(String i, String name)
	{
		id = i;
		cardholderName = name;
		materials = new ArrayList<LibraryMaterialCopy>();
		balance = 0;
	}
	
	public String getID() {return id;}
	public String getCardholderName() {return cardholderName;}
	public double getBalance(){return balance;}
	public ArrayList<LibraryMaterialCopy> getMaterialsCheckedOut() {return materials;}
	public void setCardholderName (String name) {cardholderName = name;}
	
	public boolean checkOutMaterial (LibraryMaterialCopy stuff, LocalDate todaysDate)
	//checks out book and sends message to BookCopy to check itself out too
	//returns false if book is already checked out
	//takes parameter that reflects the date that the checkout is happening
	{
		if (!stuff.checkOut(this,todaysDate) )
			return false;
		materials.add(stuff);
		return true;
	}
	
	public boolean checkOutMaterial(LibraryMaterialCopy material)
	//default check out, uses today's date
	{
		return checkOutMaterial(material, LocalDate.now());
	}
	
	public boolean returnMaterial (LibraryMaterialCopy material, LocalDate returnDate)
	//returns book and sends message to BookCopy to do the same
	//returns false if book is not checked out
	//takes parameter that expresses the date of return
	{
		LocalDate dueDate = material.getDueDate();
		if (!material.returnMaterial())
			return false;
		if (!materials.remove(material))
			return false;
		long daysBetween = ChronoUnit.DAYS.between(dueDate, returnDate);
		//System.out.println(daysBetween + "\n");
		if (daysBetween > 0) //book is returned late
		{
			balance += material.getFinePerDay() * daysBetween;
		}

		return true;
	}
	
	public boolean returnMaterial (LibraryMaterialCopy material)
	//default method, uses today's date as returns date
	{
		return returnMaterial(material, LocalDate.now());
	}
	
	public boolean renewBook(BookCopy bookcopy, LocalDate renewalDate)
	//renews book. Returns false if book is not checked out already
	//takes parameter that expresses date of renewal
	{
		if (!materials.contains(bookcopy))
			return false;
		if (!bookcopy.renew(renewalDate))
			return false;
		return true;
	}
	
	public boolean renewBook (BookCopy book)
	//default renewal method uses today's date as renewal date.
	{
		return renewBook(book, LocalDate.now());
	}
	
	
	public ArrayList<LibraryMaterialCopy>  getMaterialsOverdue (LocalDate todaysDate)
	//returns books overdue as of todaysDate
	//which means that they were actually due by yesterday
	{
		return getMaterialsDueBy(todaysDate.minusDays(1));
	}
	
	
    public ArrayList<LibraryMaterialCopy> getMaterialsDueBy(LocalDate date)
    {
        ArrayList<LibraryMaterialCopy> booksDue = new ArrayList<LibraryMaterialCopy>();
        for (LibraryMaterialCopy m : materials)
        {
            if (m.getDueDate().isBefore(date) || m.getDueDate().equals(date))
            {
                booksDue.add(m);
            }
        }
        return booksDue;
    }
	
	
	public ArrayList<LibraryMaterialCopy> getMaterialsOverdue()
	//default method, returns books overdue as of today, which means that they 
	//were due by yesterday
	{
		return getMaterialsOverdue(LocalDate.now());
	}

	public ArrayList<LibraryMaterialCopy> getMaterialsSorted()
	//returns ArrayList of books, sorted by due date (earliest due date first)
	//uses insertion sort 
	{
		for (int i = 1; i < materials.size(); i++)
		{
			int j = i;
			while (j > 0 && materials.get(j-1).getDueDate().isAfter(materials.get(j).getDueDate()))
			{
				//swap elements in positions j and j-1
				LibraryMaterialCopy temp = materials.get(j);
				materials.set(j, materials.get(j-1));
				materials.set(j-1, temp);
				
				j = j-1;
			}
		}
		return materials;
	}
}

