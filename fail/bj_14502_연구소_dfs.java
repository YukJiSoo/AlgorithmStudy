package fail;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_14502_연구소_dfs {
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map, copyMap;
	static boolean[][] visit;
	static int m, n;
	static int maxSafeArea = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		m = scan.nextInt();
		n = scan.nextInt();
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) map[i][j] = scan.nextInt();
		
		copyMap = deepCopy(map);
		dfs(0,0, true, 3);
		dfs(0,0, false, 3);
		
	}
	
	static int[][] deepCopy(int[][] original){
		if(original == null) return null;
		
		int result[][] = new int[original.length][original[0].length];
		
		for(int i=0; i<original.length; i++) {
			System.arraycopy(original[i], 0, result[i], 0, original[i].length);
		}
		
		return result;
	}
	
	static void dfs(int x, int y, boolean createWall, int wallCnt) {

		if(copyMap[y][x] == 0 && createWall) {
			copyMap[y][x] = 1;
			wallCnt -= 1;
		}
		
		if(wallCnt == 0) {
			// 바이러스 bfs로 확산
			visit = new boolean[n][m];
			
			int tempMap[][] = deepCopy(copyMap);
			for(int i=0; i<n; i++) 
				for(int j=0; j<m; j++)
					if(map[i][j] == 2) bfs(i,j);
			
			// 안전영역 비교
			checkSafeArea();
			
			// 초기
			copyMap = deepCopy(tempMap);
			copyMap[y][x] = map[y][x];
			return;
		}
		
		for(int i=0; i<4; i++) {
			int tempX = x + dx[i];
			int tempY = y + dy[i];
			
			if(tempX >= 0 && tempX < m && tempY >= 0 && tempY < n
					&& copyMap[tempY][tempX] == 0) {
				dfs(tempX, tempY, true, wallCnt);
				dfs(tempX, tempY, false, wallCnt);
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		copyMap[y][x] = 2;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int i=0; i<4; i++) {
				int tempX = p.x + dx[i];
				int tempY = p.y + dy[i];
				
				if(tempX >= 0 && tempX < m && tempY >= 0 && tempY < n
						&& copyMap[tempY][tempX] == 0 && visit[tempX][tempY] == false) {
					queue.add(new Point(tempX, tempY));
				}
			}
		}
	}
	
	static void checkSafeArea() {
		int cnt = 0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++)
				if(copyMap[i][j] == 0) cnt++;
		
		maxSafeArea = Math.max(cnt, maxSafeArea);
	}
	
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}


