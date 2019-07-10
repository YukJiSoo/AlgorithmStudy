package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_5014_스타트링크 {
	
	static int f, s, g, u, d;
	static boolean visit[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		f = scan.nextInt();
		s = scan.nextInt();
		g = scan.nextInt();
		u = scan.nextInt();
		d = scan.nextInt();
		visit = new boolean[f+1];
		
		bfs();
	}
	
	static void bfs() {
		Queue<State> queue = new LinkedList<State>();
		queue.offer(new State(s, 0));
		
		while(!queue.isEmpty()) {
			State state = queue.poll();
			
			int floor = state.floor;
			int cnt = state.cnt;
			visit[floor] = true;
			
			if(floor == g) {
				System.out.println(cnt);
				return;
			}
			if(floor+u <= f && !visit[floor+u]) {
				visit[floor+u] = true;
				queue.offer(new State(floor + u, cnt +1));
			}
			if(floor-d >= 1 && !visit[floor-d]) {
				visit[floor-d] = true;
				queue.offer(new State(floor - d, cnt +1));
			}
		}
		
		System.out.println("use the stairs");
	}
	
	static class State {
		int floor, cnt;
		
		public State(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}

}
