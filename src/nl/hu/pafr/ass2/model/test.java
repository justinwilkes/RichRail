package nl.hu.pafr.ass2.model;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	
	
	public static void main(String[] args) throws ParseException {

		String someInput = "new train rr";
	    Pattern r = Pattern.compile("(.*)\\s(.*)\\s(.*)");
	    Matcher m = r.matcher(someInput);

	   // if (m.matches()) {
	        System.out.println(m.group(3));
	   // }
		
	}
}
