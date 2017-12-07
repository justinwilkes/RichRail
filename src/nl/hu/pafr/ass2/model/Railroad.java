package nl.hu.pafr.ass2.model;

import java.util.ArrayList;

public class Railroad {
	private ArrayList<Train> trains;
	private ArrayList<Wagon> wagons;
	private Train selectedTrain = null;	
	
	public Railroad() {
		trains = new ArrayList<Train>();
		wagons = new ArrayList<Wagon>();
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}
	
	public void addTrain(Train train) {
		trains.add(train);
	}
	
	public ArrayList<Wagon> getWagons() {
		return wagons;
	}
	
	public void addWagon(Wagon wagon) {
		wagons.add(wagon);
	}
	
	public Train getSelectedTrain() {
		return selectedTrain;
	}

	public void setSelectedTrain(Train selectedTrain) {
		this.selectedTrain = selectedTrain;
	};
}
