package heap;

import java.util.PriorityQueue;

// 우선순위 큐(힙)을 사용하면 쉽게 풀리는 문

public class pm_더맵게 {
	public static void main(String[] args) {
		int[] scoville = new int[123];
		int K = 0;
		int answer = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int element : scoville) {
			queue.offer(element);
		}
		
		while(queue.peek() < K) {
			int first = queue.poll();
			int second = queue.poll();
			
			queue.offer(first + second*2);
			answer += 1;
			
			if(queue.size() == 1 && queue.peek() < K) {
				answer = -1;
				break;
			}
		}
	}

}
