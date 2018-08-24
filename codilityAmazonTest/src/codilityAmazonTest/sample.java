package codilityAmazonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("friday night");
		solution(new int[] { 1, 5, 4, 9, 8, 7, 12, 13, 14 });
	}

	public static int solution(int[] A) {
        // write your code in Java SE 8
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> currentGroup = new ArrayList<>();
        groups.add(currentGroup);
        for(int i =0; i< A.length -1; i++) {
        	if(!currentGroup.isEmpty()) {
        		if(currentGroup.get(currentGroup.size()-1) - A[i] == 1 
        				|| currentGroup.get(currentGroup.size()-1) - A[i+1] == -1) {
            		
            		currentGroup.add(A[i]);
            		currentGroup.add(A[i+1]);
            		i++;
            	} else {
            		currentGroup = new ArrayList<>();
            		groups.add(currentGroup);
            	}
        		continue;
        	}
        	if(A[i] - A[i+1] == 1 || A[i] - A[i+1] == -1) {
        		
        		currentGroup.add(A[i]);
        		currentGroup.add(A[i+1]);
        		i++;
        	}
        	else {
        		currentGroup.add(A[i]);
        		currentGroup = new ArrayList<>();
        		groups.add(currentGroup);
        	}
        }
        
        System.out.println(groups);
        return groups.size();
        
    }
}
