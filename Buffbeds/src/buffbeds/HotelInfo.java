package buffbeds;

public class HotelInfo {
	String location;
	double pricePerNight;
	int hostId;
	int NumOfPersons;
	String bookedDates;

	public HotelInfo() {
		// Default constructor stub
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public int getNumOfPersons() {
		return NumOfPersons;
	}

	public void setNumOfPersons(int numOfPersons) {
		NumOfPersons = numOfPersons;
	}

	public String getBookedDates() {
		return bookedDates;
	}

	public void setBookedDates(String bookedDates) {
		this.bookedDates = bookedDates;
	}

}
