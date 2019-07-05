package hash;

import java.util.HashMap;

public class pm_완주하지못한선수 {
	
	public static void main(String[] args) {
		String participant[] = {}; 
		String completion[] = {};
		
		solution(participant, completion);
	}
	
	static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<completion.length; i++) {
        	if(map.containsKey(completion[i])) {
        		map.put(completion[i], map.get(completion[i])+1);
        	}
        	else {
        		map.put(completion[i], 1);
        	}  
        }
        
        for(int i=0; i<participant.length; i++) {
        	if(map.containsKey(participant[i]) && map.get(participant[i]) > 0) {
        		map.put(participant[i], map.get(participant[i])-1);
        	}
        	else {
        		answer = participant[i];
        		break;
        	}
        }
        
        
        return answer;
    }
}
