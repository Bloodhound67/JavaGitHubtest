

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeHandler {

	private static ArrayList<BookedTime> timeBookedList = new ArrayList<>();

	public BookedTime createBookedTime(String name, LocalDateTime bookedStartTime, LocalDateTime bookedStopTime) {
		return new BookedTime(name, bookedStartTime, bookedStopTime);
	}

	public void addBookedTime(BookedTime bt) {
		timeBookedList.add(bt);
	}

	public boolean checkTime(LocalDateTime bookedStartTime, LocalDateTime bookedStopTime) {
		for (BookedTime current : timeBookedList) {

			if (bookedStartTime.isAfter(current.getBookedStopTime())
					|| (bookedStopTime.isBefore(current.getBookedStartTime()))) {
			} 
			else {		
				return false;
			}
		}
		return true;
	}

	public static void listBookedTime() {
		// Här listas de bokningar som du har gjorti din Arraylist
		BookedTime b;
		int tBLs = timeBookedList.size();
		for (int i = 0; i < tBLs; i++) {
			b = timeBookedList.get(i);
			System.out.println("Bokning " + (i + 1) + " \n" + b.getBookedStartTime());

		}
	}
	
	
	public static boolean intervallChecker(LocalDateTime bookedStartTime, LocalDateTime bookedStopTime) {
		String s = "08:00";
		String c = ""
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime open = LocalDateTime.parse(s, formatter);
		if (bookedStartTime.isBefore(open)) {
			intervallChecker = false;			
		}
		if (bookedStartTime.isBefore(open) )
		
		
		
		
		return false;
	}{ 
}
}
