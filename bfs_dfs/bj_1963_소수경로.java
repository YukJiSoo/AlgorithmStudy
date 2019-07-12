package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1963_소수경로 {
	
	static int start, end, t;
	static int result[];
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		t = scan.nextInt();
		result = new int[t];

		while(t-- > 0) {
			start = scan.nextInt();
			end = scan.nextInt();
			
			bfs();
		}
		
		for(int i=0; i<result.length; i++) {
			if(result[i] == -1) System.out.println("Impossible");
			else System.out.println(result[i]); 
		}
		
	}
	
	static void bfs() {
		visit = new boolean[10000];
		Queue<Step> queue = new LinkedList<Step>();
		queue.offer(new Step(start, 0));
		visit[start] = true; 
		
		if(start == end) {
			result[result.length - (t+1)] = 0;
			return;
		}
		
		while(!queue.isEmpty()) {
			Step s = queue.poll();
			int now = s.num;
			
			for(int i=1; i<=1000; i*=10) {
				int temp = now - (( now % (i*10) ) / i) * i;
				
				for(int j=0; j<=9; j++) {

					if(!visit[temp + j*i] && isPrimeNumber(temp + j*i) && ((temp + j*i) >= 1000)) {
						if(temp + j*i == end) {
							result[result.length - (t+1)] = s.cnt+1; 
							return;
						}
						
						queue.offer(new Step(temp + j*i, s.cnt+1));
						visit[temp + j*i] = true;
					} 
						
				}
			}
		}
		
		result[result.length - (t+1)] = -1;
	}
	
	static boolean isPrimeNumber(int num) {
		if(num <= 1) return false;
		
		for(int i=2; i<=num/2; i++) {
			if(num%i == 0) return false;
		}
		
		return true;
	}
	
	static class Step {
		int num, cnt;
		
		public Step(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

}
