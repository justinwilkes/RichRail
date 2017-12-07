package nl.hu.pafr.ass2.model;

public class Wagon {
	
	// Attributes
	private String name;
	private int numseats;
	
	// Constructor
	public Wagon(String name) {		
		this.name = name;	
		this.numseats = 20;
	}	
	
	public Wagon(String name, int numseats) {
		this.name = name;
		this.numseats = numseats;
	}
	
	

	// Getters	
	public String getName() {		return this.name;		}	
	public int getSeats() {			return this.numseats;	}
}
