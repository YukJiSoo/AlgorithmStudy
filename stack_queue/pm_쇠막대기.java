package stack_queue;

import java.util.Stack;

/* 스택, 큐 
 * 스택을 이용해보자
 * 1. )) : 막대기의 끝, 잘린 막대기 개수 1개 추가
 * 2. () : 레이저, ( 개수만큼 잘린 막대기 개수 추가
 * 3. ( : 그냥 스택에 추가, 막대기 개수 1 추가
 */

public class pm_쇠막대기 {
	public static void main(String[] args) {
		String arrangement = "";
        int answer = 0;
        
        Stack<Character> stack = new Stack<Character>();
        stack.push(arrangement.charAt(0));
        int stick = 1;
        
        for(int i=1; i<arrangement.length(); i++) {
        	char now = arrangement.charAt(i);
        	char top = stack.peek();
        	
        	if(now == '(') {
        		stick += 1;
        		stack.push(now);
        	}
        	else if(top == '(') {
        		stick -= 1;
        		answer += stick;
        		stack.push(now);
        	}
        	else if(top == ')') {
        		stick -= 1;
        		answer += 1;
        		stack.push(now);
        	}
        	
        	
        }
        
        
        
        
	}
	
	
}
