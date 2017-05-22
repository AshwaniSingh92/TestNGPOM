package FactoryMethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ListPopulator {
	
	
	
	public List<String> lpobject(List<WebElement> flight, List<WebElement> price, List<WebElement> arr, List<WebElement> dep){
		
		List<String> cl = new ArrayList<String>();
		
		int i =0;
		
		for(WebElement x : flight){				
			
			cl.add("Flight: "+x.getText().trim()+":"+"Departure: "+dep.get(i).getText()+"Arrival: "+arr.get(i).getText()+"Price: "+price.get(i).getText());					
		    i++;
		    
		}
		
				
		
		
		return cl;
		
		
	}

}
