package buffbeds;

public class Filter {
	private String DateRange;
	private float PriceRange;
	private int noOfPeople;
	private String Location;
	
	public Filter()
	{
		
	}

	public String getDateRange() {
		return DateRange;
	}

	public void setDateRange(String dateRange) {
		DateRange = dateRange;
	}

	public float getPriceRange() {
		return PriceRange;
	}

	public void setPriceRange(float priceRange) {
		PriceRange = priceRange;
	}

	public int getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
	
}
