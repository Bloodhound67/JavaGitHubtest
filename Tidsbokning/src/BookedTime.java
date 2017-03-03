import java.time.LocalDateTime;

public class BookedTime {

	private LocalDateTime bookedStartTime;
	private LocalDateTime bookedStopTime;
	private String name;

	public String getName() {
		return name;
	}

	public BookedTime(String name, LocalDateTime bookedStartTime, LocalDateTime bookedStopTime) {
		this.bookedStartTime = bookedStartTime;
		this.bookedStopTime = bookedStopTime;
		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBookedStartTime() {
		return bookedStartTime;
	}

	public void setBookedStartTime(LocalDateTime bookedStartTime) {
		this.bookedStartTime = bookedStartTime;
	}

	public LocalDateTime getBookedStopTime() {
		return bookedStopTime;
	}

	public void setBookedStopTime(LocalDateTime bookedStopTime) {
		this.bookedStopTime = bookedStopTime;
	}
}
