package pl.edu.utp.wtie;

public class Car {
	
	@Regexp(pattern="\\d{2}-\\d{3}", message="Type car brand.")
	private String brand = "";
	
	private String model = "Passat";
	private int yearOfProduction = 2006;
	private Integer yearOfProduction2 = 2006;
	private String diesel = "true";
	private String text = "This is very popular car.";
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}
	
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	
	public String getDiesel() {
		return diesel;
	}
	
	public void setDiesel(String diesel) {
		this.diesel = diesel;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public Integer getYearOfProduction2() {
		return yearOfProduction2;
	}

	public void setYearOfProduction2(Integer yearOfProduction2) {
		this.yearOfProduction2 = yearOfProduction2;
	}
}
