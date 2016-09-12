package com.corejava;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestNumber {
	static String number = "010";
	static List<Integer> allPossibleNum;
	
	public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){ 
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
 
    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    private static int largestNum(Set<String> allPossibleNum) {
    	int max = 0;
    	for(String num : allPossibleNum) {
    		int numInt = Integer.parseInt(num);
    		if(numInt > max) {
    			max = numInt; 
    		}
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		System.out.println(largestNum(permutationFinder(number)));
	}

}
