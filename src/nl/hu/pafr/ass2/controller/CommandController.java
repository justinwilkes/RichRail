package nl.hu.pafr.ass2.controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.hu.pafr.ass2.model.Railroad;

public class CommandController {	
	private Controller contr;
	
	
	
	/**
	 * @param railroad : Railroad
	 * 
	 * @Description Constructor
	 */
	public CommandController(Railroad railroad) {		
		contr = new Controller(railroad);
	}
	
	
	
	/**
	 * @param command : String 
	 * @return String for the response output
	 * 
	 * @Description Splits the command by running multiple 
	 * methods and execute the command by their index
	 */
	public String executeCommand(String command) {
		int functionIndex = getIndexFunction(command);		
		ArrayList<String> parameters = getParameters(command, functionIndex);
		
		
		switch (functionIndex) {
			case 0:				// New Train				
				return contr.createTrain(parameters.get(0));			
			
			case 1:				// New Wagon
				return contr.createWagon(parameters.get(0));
			
			case 2:				// New Wagon with numseats
				return contr.createWagon(parameters.get(0), Integer.parseInt(parameters.get(1)));
			
			case 3:				// Add Wagon to Train
				return "";
			
			case 4:				// get numseats train
				return contr.trainNumSeats(parameters.get(0));
			
			case 5:				// get numseats wagon
				return contr.wagonNumSeats(parameters.get(0));
			
			case 6:				// delete train
				return contr.deleteTrain(parameters.get(0));
			
			case 7:				// Delete Wagon				
				return contr.deleteWagon(parameters.get(0));
			
			case 8:				// remove wagon from train
				return  "";			
		}		
		
		return "No valid command";
	}
	
	
	
	/**
	 * @param command : String
	 * @return int for the needed function to run
	 * 
	 * @Description Returns index when the command 
	 * matches the regex 
	 */
	public int getIndexFunction(String command) {	
		if(command.matches("(new)\\s(train)\\s[\\w]+")) 						return 0;		// New Train
		if(command.matches("(new)\\s(wagon)\\s[\\w]+")) 						return 1;		// New Wagon
		if(command.matches("(new)\\s(wagon)\\s[\\w]+\\s(numseats)\\s[\\w]+")) 	return 2;		// New Wagon With Numseats
		if(command.matches("(add)\\s[\\w]+\\s(to)\\s[\\w]+")) 					return 3;		// Add Wagon To Train
		if(command.matches("(getnumseats)\\s(train)\\s[\\w]+")) 				return 4;		// Get Number Of Seats From Train
		if(command.matches("(getnumseats)\\s(wagon)\\s[\\w]+")) 				return 5;		// Get Number Of Seats From Wagon
		if(command.matches("(delete)\\s(train)\\s[\\w]+")) 						return 6;		// Delete Train
		if(command.matches("(delete)\\s(wagon)\\s[\\w]+")) 						return 7;		// Delete Wagon
		if(command.matches("(remove)\\s[\\w]+\\s(from)\\s[\\w]+")) 				return 8;		// Remove Wagon From Train
			
		return -1;		// No correct command
	}
	
	
	
	public ArrayList<String> getParameters(String command, int index) {
		ArrayList<String> parameters = new ArrayList<String>();
		
		
		// [WORD] [WORD] [PARAMETER]
		if(index == 0 || index == 1 || index == 4 || index == 5 || index == 6 || index == 7) {
			Pattern r = Pattern.compile("(.*)\\s(.*)\\s(.*)");
		    Matcher m = r.matcher(command);
		    if (m.matches()) {			    
		    	parameters.add(m.group(3));		
		    }
		    
		    
		// [WORD] [WORD] [PARAMETER] [WORD] [PARAMETER]
		} else if(index == 2) {		
			Pattern r = Pattern.compile("(.*)\\s(.*)\\s(.*)\\s(.*)\\s(.*)");
		    Matcher m = r.matcher(command);
		    if (m.matches()) {			    
		    	parameters.add(m.group(3));
		    	parameters.add(m.group(5));		
		    }
		    
		    
		// [WORD] [PARAMETER] [WORD] PARAMETER] 
		} else if(index == 3 || index == 8) {
			Pattern r = Pattern.compile("(.*)\\s(.*)\\s(.*)\\s(.*)");
		    Matcher m = r.matcher(command);
		    if (m.matches()) {			        
		    	parameters.add(m.group(2));
		    	parameters.add(m.group(4));			
		    }
		}		
		
		return parameters;		
	}
}
