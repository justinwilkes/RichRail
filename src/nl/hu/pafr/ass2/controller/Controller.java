package nl.hu.pafr.ass2.controller;

import java.util.ArrayList;

import nl.hu.pafr.ass2.model.Railroad;
import nl.hu.pafr.ass2.model.Train;
import nl.hu.pafr.ass2.model.Wagon;

public class Controller {
	private Railroad railroad;
	
	public Controller(RailRoad railroad) {
		this.railroad = railroad;
	}
	
	
	
	
	/**
	 * Wagons
	 */
	
	public String createWagon(String name) {
		return "";
	}
	
	
	
	public String deleteWagon(String name) {
		return "";
	}
	
	
	public boolean wagonExists(Train t) {
		for(Train train : trains) {
			if(train.getName().equals(t.getName())) return true;
			else return false;
		}
		return false;
	}
	
	
	
	
	
	/**
	 * Trains
	 */	
	
	
	public String createTrain(String name) {
		Train newTrain = new Train(name);
		if(!trainExists(newTrain)) {
			selectedTrain = newTrain;
			trains.add(newTrain);
			return "Train " + name + " created";
		} else return "Train " + name + " already exists";		
	}
	
	public String deleteTrain(String name) {
		return ""; 
	}
	
	
	public boolean trainExists(Train t) {
		for(Train train : trains) {
			if(train.getName().equals(t.getName())) return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	// Getters
	public Train getSelectedTrain() {				return this.selectedTrain;		}
	public ArrayList<Train> getTrains() {			return this.trains;				}
	
	
	// Setters
	public void setSelectedTrain(Train train) {		this.selectedTrain = train;		}
}
