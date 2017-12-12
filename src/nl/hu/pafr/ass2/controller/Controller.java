/**
 * TODO
 * - Add method remove [WAGON] from [TRAIN]
 * - Add Method add [WAGON] to [TRAIN]
 * - Add Method getnumseats train [TRAIN]
 * - Add Method getnumseats wagon [WAGON]
 * - Add Method new wagon [WAGON] numseats [NUMSEATS]
 */


package nl.hu.pafr.ass2.controller;

import nl.hu.pafr.ass2.model.Railroad;
import nl.hu.pafr.ass2.model.Train;
import nl.hu.pafr.ass2.model.Wagon;

public class Controller {
	private Railroad railroad;
	
	
	/**
	 * @param railroad : Railroad
	 * 
	 * @Description Constructor
	 */
	public Controller(Railroad railroad) {
		this.railroad = railroad;
	}

	
	
	/**
	 * @param name : String
	 * @return String for the response output
	 * 
	 * @Description Creates a new wagon and adds the new wagon to 
	 * an arrayList in the class railroad
	 */
	public String createWagon(String name) {
		Wagon newWagon = new Wagon(name);
		if(!wagonExists(newWagon)) {
			railroad.addWagon(newWagon);
			return "Wagon " + name + " created";
		} else return "Wagon " + name + " already exists";		
	}
	
	
	
	/**
	 * @param name : String, numseats : int
	 * @return String for the response output
	 * 
	 * @Description Creates a new wagon with numseats
	 * and adds the new wagon to an arrayList in the 
	 * class railroad
	 */
	public String createWagon(String name, int numseats) {
		Wagon newWagon = new Wagon(name, numseats);
		if(!wagonExists(newWagon)) {
			railroad.addWagon(newWagon);
			return "Wagon " + name + " created with " + numseats + " seats";
		} else return "Wagon " + name + " already exists";		
	}
	
	
	
	/**
	 * @param name : String
	 * @return String for the response output
	 * 
	 * @Description Deletes the wagon with the given
	 * name, if exists
	 */
	public String deleteWagon(String name) {
		if(wagonExists(new Wagon(name))) {
			railroad.deleteWagon(name);
			return "Wagon " + name + " deleted";
		} else return "Wagon " + name + " does not exists";		
	}
	
	
	
	/**	
	 * @param w : Wagon w
	 * @return boolean if wagon exists
	 * 
	 * @Description Checks if the given wagon exists in the 
	 * array from the class railroad
	 */
	public boolean wagonExists(Wagon w) {
		for(Wagon wagon : railroad.getWagons()) {
			if(wagon.getName().equals(w.getName())) return true;	
		}
		return false;
	}
	
	
	
	/**
	 * @param name : String
	 * @return String for the response output
	 * 
	 * @Description Returns the number of seats 
	 * from the wagon with the given name
	 */
	public String wagonNumSeats(String name) {
		for (Wagon wagon : railroad.getWagons()) {
			if (wagon.getName().equals(name)) {
				return Integer.toString(wagon.getnumSeats());
			}
		}
		return "Wagon " + name + " does not exist";
	}
	
	
	
	/**
	 * @param name : String
	 * @return String for the response output
	 * 
	 * @Description Creates a new train and adds the new train to 
	 * an arrayList in the class railroad
	 */
	public String createTrain(String name) {
		Train newTrain = new Train(name);
		if(!trainExists(newTrain)) {
			railroad.setSelectedTrain(newTrain);
			railroad.addTrain(newTrain);
			return "Train " + name + " created";
		} else return "Train " + name + " already exists";		
	}
	
	
	
	/**
	 * @param name : String
	 * @return String for the response output
	 * 
	 * @Description Deletes the train with the given
	 * name, if exists
	 */
	public String deleteTrain(String name) {		
		if(trainExists(new Train(name))) {
			railroad.removeTrain(name);
			return "Train " + name + " deleted";
		} else return "Train " + name + " does not exist";		
	}
	
	
	
	/**
	 * @param name : String
	 * @return String for the response output
	 * 
	 * @Description Returns the number of seats 
	 * from the train with the given name
	 */
	public String trainNumSeats(String name) {
		for (Train train : railroad.getTrains()) {
			if (train.getName().equals(name)) {
				return Integer.toString(train.getNumSeats());
			}
		}
		return "Train " + name + " does not exist";
	}
	
	
	
	/**	
	 * @param t : Train
	 * @return boolean if train exists
	 * 
	 * @Description Checks if the given train exists in the 
	 * array from the class railroad
	 */
	public boolean trainExists(Train t) {
		for(Train train : railroad.getTrains()) {
			if(train.getName().equals(t.getName())) return true;	
		}
		return false;
	}
}