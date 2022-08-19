package utils;

import java.util.ArrayList;
import java.util.List;

public class Common {
	
	public List<String> generateList(int size){
		List<String> fixedSizeList = new ArrayList<String>();
		
		for(int i=0;i<size;i++) {
			fixedSizeList.add(getAlphaNumericString());
		}
		
		return fixedSizeList;
	}
	
	  public String getAlphaNumericString()
	    {
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz";
	  
	        StringBuilder sb = new StringBuilder(5);
	        for (int i = 0; i < 5; i++) {
	            int index
	                = (int)(AlphaNumericString.length()
	                        * Math.random());
	            sb.append(AlphaNumericString
	                          .charAt(index));
	        }
	  
	        return sb.toString();
	    }

}
