package nl.hu.pafr.ass2.model;

import java.util.ArrayList;


public class Train {
	
	// Attributes
	private String name;
	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
			
	
	// Constructor
	public Train(String name) {				this.name = name;			}
	
	// Methods
	public void addWagon(Wagon wagon) {		this.wagons.add(wagon);		}
	public void clearWagons() {				wagons.clear(); 	 		}	
	
	// Getters
	public String getName() {				return this.name;			}
	public ArrayList<Wagon> getWagons() {	return this.wagons; 		}	
	public boolean hasName() {				return (this.name != "");	}
	
	
	public int getNumseats() {
		int numseatsTotal = 0;
		for(Wagon w : wagons) {
			numseatsTotal += w.getSeats();
		}
		return numseatsTotal;		
	}
}
