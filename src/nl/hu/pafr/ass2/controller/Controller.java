package nl.hu.pafr.ass2.controller;

import java.util.ArrayList;
import nl.hu.pafr.ass2.model.Train;
import nl.hu.pafr.ass2.model.Wagon;

public class Controller {
	
	private ArrayList<Train> trains = new ArrayList<Train>();
	private ArrayList<Wagon> wagons = new ArrayList<Wagon>();
	private Train selectedTrain = null;
	
	public Controller() {}
	
	
	
	
	
	
	
	public String newTrain(String name) {
		Train newTrain = new Train(name);
		if(!trainExists(newTrain)) {
			selectedTrain = newTrain;
			trains.add(newTrain);
			return "Train " + name + " created";
		} else return "Train " + name + " already exists";		
	}
	
	
	public boolean trainExists(Train t) {
		for(Train train : trains) {
			if(train.getName().equals(t.getName())) return true;
			else return false;
		}
		return false;
	}
	
	
	// Getters
	public Train getSelectedTrain() {				return this.selectedTrain;		}
	public ArrayList<Train> getTrains() {			return this.trains;				}
	
	
	// Setters
	public void setSelectedTrain(Train train) {		this.selectedTrain = train;		}
}
