

import java.time.LocalDateTime;
import java.time.LocalTime;
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


		if (intervallChecker(bookedStartTime.toLocalTime(), bookedStopTime.toLocalTime())) {
			System.out.println("tiden är inom när vi är öppet");
		} else {
			System.out.println("Det går inte att boka den är tiden");
			return false;
		}


		for (BookedTime current : timeBookedList) {

			if (bookedStartTime.isAfter(current.getBookedStopTime())
					|| (bookedStopTime.isBefore(current.getBookedStartTime()))) {
			} else {
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


	public static boolean intervallChecker(LocalTime bookedStartTime, LocalTime bookedStopTime) {
		String s = "08:00";
		String c = "18:00";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime open = LocalTime.parse(s, formatter);
		LocalTime close = LocalTime.parse(c, formatter);

		return (bookedStartTime.compareTo(open) >= 0 && bookedStartTime.compareTo(close) <= 0)
				&& (bookedStopTime.compareTo(open) >= 0 && bookedStopTime.compareTo(close) <= 0);
	}

}
// }
