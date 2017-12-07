package nl.hu.pafr.ass2.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandController {
	
	public CommandController() { }
	
	
	// Returns the index for the matching regex
	public int getIndexFunction(String command) {	
		if(command.matches("(new)\\s(train)\\s[\\w]+")) 						return 0;		// New Train
		if(command.matches("(new)\\s(wagon)\\s[\\w]+")) 						return 1;		// New Wagon
		if(command.matches("(new)\\s(wagon)\\s[\\w]+\\s(numseats)\\s[\\w]+")) 	return 2;		// New Wagon With Numseats
		if(command.matches("(add)\\s[\\w]+\\s(to)\\s[\\w]+")) 					return 3;		// Add Wagon To Train
		if(command.matches("(getnumseats)\\s(train)\\s[\\w]+")) 				return 4;		// Get Number Of Seats From Train
		if(command.matches("(getnumseats)\\s(wagon)\\s[\\w]+")) 				return 5;		// Get Number Of Seats From Wagon
		if(command.matches("(delete)\\s(train)\\s[\\w]+")) 						return 6;		// Delete Train
		if(command.matches("(remove)\\s[\\w]+\\s(from)\\s[\\w]+")) 				return 7;		// Remove Wagon From Train
			
		return -1;		// No correct command
	}
	
	
	
	public String getItems(String command, int index) {
		//return "";
		
		if(index == 0 || index == 1 || index == 4 || index == 5 || index == 6 || index == 7) {
			Pattern r = Pattern.compile("(.*)\\s(.*)\\s(.*)");
		    Matcher m = r.matcher(command);
		    if (m.matches()) {			    
		    	return (m.group(3));		
		    }
		} else {
			Pattern r = Pattern.compile("(.*)\\s(.*)\\s(.*)");
		    Matcher m = r.matcher(command);
		    if (m.matches()) {			    
		    	return (m.group(3));		
		    }
		}
		
		
		return null;
		
	}
}
