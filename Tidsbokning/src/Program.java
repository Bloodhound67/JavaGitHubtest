import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class Program {
	static InputHandler ih = new InputHandler();
	static TimeHandler th = new TimeHandler();

	public static void main(String[] args) {



		String svar = "";

		do {
			System.out.println(
					" Välkommen. Vill du boka tid? Välje ett alternativ \n "
					+ "1. Skriv in start och stopptid för din bokning  \n "
					+ "2. Skriv ut en lista över bokningarna \n "
					+ "3. Avsluta programmet");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				
				svar = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Kunde inte läsa input");
				break;
			}

			switch (svar) {


			case "1":
				BookedTime bookedCheckedTime = null;
				try {
					bookedCheckedTime = ih.timeInputCheck();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Kunde inte läsa input");
					break;
				}
				
					
				if (bookCheck(bookedCheckedTime)) {
					// Här formaterar jag om datum så att det skrivs ut snyggt.					
					 LocalDateTime dateStart =
					 bookedCheckedTime.getBookedStartTime(); LocalDateTime
					 dateStop = bookedCheckedTime.getBookedStopTime();
					 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
					 String textStart = dateStart.format(formatter); 
					 String textStop = dateStop.format(formatter);
					 System.out.println("Tack för din bokning " + " " + bookedCheckedTime.getName() + " \n" +
					 "Din bokning är mellan " + textStart + " och " + textStop + "\n" );					
				}
				break;

			case "2":
				TimeHandler.listBookedTime();
				break;

			default: 
				if( svar.equals("3")){
					System.out.println("Tack för att du har använt detta program");
					break;
				}
				System.out.println("Du måste ange ett av de ovan nämna alternativen");
				break;
			}


		} while (!svar.equals("3"));

	}



	static boolean bookCheck(BookedTime bookedCheckedTime) {

		if (!th.checkTime(bookedCheckedTime.getBookedStartTime(), bookedCheckedTime.getBookedStopTime())) {
			System.out.println("Din bokning gick inte igenom pga dubbelbokning ");

			return false;
		}
		if (bookedCheckedTime.getBookedStopTime().isBefore(bookedCheckedTime.getBookedStartTime())) {
			System.out.println("Du kan inte sätta en stoptid före starttiden ");
			return false;
		} else {
			String name = bookedCheckedTime.getName();
			BookedTime bt = th.createBookedTime(name, bookedCheckedTime.getBookedStartTime(),
					bookedCheckedTime.getBookedStopTime());
			th.addBookedTime(bt);

			return true;

		}
	}

}

