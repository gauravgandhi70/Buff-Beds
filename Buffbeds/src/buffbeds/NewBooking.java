package buffbeds;

import buffbeds.Filter;

public class NewBooking {

	private Filter filtercriteria;
	private Boolean extraBed;
	private Boolean food;
	private float Total;
	
	public NewBooking()
	{
		
	}

	public Filter getFiltercriteria() {
		return filtercriteria;
	}

	public void setFiltercriteria(Filter filtercriteria) {
		this.filtercriteria = filtercriteria;
	}

	public Boolean getExtraBed() {
		return extraBed;
	}

	public void setExtraBed(Boolean extraBed) {
		this.extraBed = extraBed;
	}

	public Boolean getFood() {
		return food;
	}

	public void setFood(Boolean food) {
		this.food = food;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}
	
	
}
