package hash;

import java.util.HashMap;

public class pm_전화번호목록 {
	public static void main(String[] args) {
		
	}
	
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<phone_book.length; i++) {
        	
        	String num = phone_book[i];
        	for(int j=1; j<=num.length(); j++) {
        		map.put(num.substring(0, j), map.getOrDefault(num.substring(0, j), -1)+1);
        	}
        }
        
        for(String key: phone_book) {
        	if(map.get(key) > 0) {
        		answer = false;
        		break;
        	}
        }
        
        return answer;
    }
}
