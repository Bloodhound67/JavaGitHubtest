import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputHandler {
	static TimeHandler th = new TimeHandler();

	public BookedTime timeInputCheck() throws IOException {
		// Här matar användaren in namn och de önskade tider som användaren vill
		// boka.
		// Här kontrolleras om inmatningen är ett giltigt sätt att mata in
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String bookStartinput;
		String bookStopinput;

		String name;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
		LocalDateTime bookedStartTime = null;
		LocalDateTime bookedStopTime = null;
		boolean shouldCont = false;

		System.out.println("Välkommen! Skriv in ditt namn.  \n ");
		name = reader.readLine();

		do {
			System.out.println("Ange starttid ");
			System.out.println("yy-MM-dd HH:mm");
			try {
				bookStartinput = reader.readLine().trim();
				bookedStartTime = LocalDateTime.parse(bookStartinput, formatter);
				shouldCont = false;
			} catch (Exception e) {
				System.out.println("Skriv in ett giltigt datum ");
				shouldCont = true;
			}
		} while (shouldCont);

		do {
			System.out.println("Ange stopptid ");
			System.out.println("yy-MM-dd HH:mm ");
			try {
				bookStopinput = reader.readLine().trim();
				bookedStopTime = LocalDateTime.parse(bookStopinput, formatter);
				shouldCont = false;

			} catch (Exception e) {
				System.out.println("Skriv in ett giltigt datum ");
				shouldCont = true;
			}
		} while (shouldCont);
		return new BookedTime(name, bookedStartTime, bookedStopTime);
	}


}
