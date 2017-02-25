import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;

public class TryingOut {
	
	public static void main (String[] args)
	{
		//get todays date
		LocalDate todaysDate = LocalDate.now();
		System.out.println("Today's date is: " + todaysDate);
		
		//extract date, month, year
		int day = todaysDate.getDayOfMonth();
		int month = todaysDate.getMonthValue();
		int year = todaysDate.getYear();
		System.out.println("Date: " + day + " Month: " + month + " Year: " + year);
		
		//create date object that contains November 5, 2005
		LocalDate specialDate = LocalDate.of(2005,  11,  05);
		System.out.println(specialDate + " is a special date");
		
		//creating a MonthDay
		MonthDay todaysMonthDay = MonthDay.now();
		System.out.println("Todays month and date " + todaysMonthDay);
		
		LocalDate feb232007 = LocalDate.of(2007,  02,  23);	
		MonthDay feb23 = MonthDay.of(feb232007.getMonthValue(), feb232007.getDayOfMonth());
		
		if (feb23.equals(todaysMonthDay))
			System.out.println("They are the same");
		else
			System.out.println("They are not the same");
		
		
		//creating a YearMonth
		YearMonth todaysYearMonth = YearMonth.now();
		LocalDate creditCard1 = LocalDate.of(2017,  02,  02);	
		YearMonth creditCardExpiration = YearMonth.of(creditCard1.getYear(), creditCard1.getMonthValue());
		if (creditCardExpiration.equals(todaysYearMonth))
			System.out.println("Your credit card expires this month");
		else
			System.out.println("Your credit card does not expire this month");
		
		//get the date that is a week after today
		LocalDate weekLater = todaysDate.plusWeeks(1);
		
		//get the date that is a year before today
		LocalDate yearBefore = todaysDate.minusYears(1);
		
		//check if two dates are equal
		if (yearBefore.equals(weekLater))
			System.out.println("equal!");
		
		//check if date is before a different date
		if (yearBefore.isBefore(weekLater))
			System.out.println(yearBefore + " is before " + weekLater);
		
	}
}
