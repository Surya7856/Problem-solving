//https://www.codingninjas.com/studio/problem-of-the-day/easy

import java.util.* ;
import java.io.*; 

public class Solution {

	public static boolean isValidIPv4(String ipAddress) {
		// write your code here
		int no=0;
		int dc=0;
		for(int i=0;i<ipAddress.length();i++){
			char currentChar=ipAddress.charAt(i);
			if(currentChar=='.'){
				dc++;
				if(dc>3)
					return false;
				if(!(no<=255 && no>=0))
					return false;
				no=0;
			}
			else if (Character.isDigit(currentChar)){
				no = no * 10 + Character.getNumericValue(currentChar);
				if(no>255)
					return false;
			}
			else
				return false;
		}
		if (!(no >= 0 && no <= 255))
        	return false;
		return dc==3;
	}

}
