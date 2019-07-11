package fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1707_이분그래프_fail {
	
	static int v, e;
	static int graph[][];
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		boolean isAbles[] = new boolean[t];
		
		for(int i=0; i<t; i++) {
			v = scan.nextInt();
			e = scan.nextInt();
			
			graph = new int[v+1][v+1];
			for(int j=0; j<e; j++) {
				int point1 = scan.nextInt();
				int point2 = scan.nextInt();
				
				graph[point1][point2] = 1;
				graph[point2][point1] = 1;
			}
			
			bfs();
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
	}
	
	static void dfs() {
		
	}
}
