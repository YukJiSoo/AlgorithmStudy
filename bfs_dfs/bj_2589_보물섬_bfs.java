package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

// BFS
// W인 경우는 그냥 통과
// 방문내역을 관리하는 배열 사용 - visit
// 최단거리로 이동하지만 가장 긴시간이 걸려야 함 - 각 L마다의 bfs 함수 실행 결과로 판단?
// 문제내의 최단거리라는 말이 bfs를 사용하라는 것, 가장 긴시간은 최댓값을 구하라는 것 같다.

import java.util.Scanner;

public class bj_2589_보물섬_bfs {
	
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	static char map[][];
	static int h, w;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		h = scan.nextInt();
		w = scan.nextInt();
		
		map = new char[h][w];
		
		for(int i=0; i<h; i++) {
			String str = scan.next();
			for(int j=0; j<w; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j] == 'W') continue;
				BFS(j, i);
			}
		}
		
		System.out.println(result);
	}
	
	static void BFS(int x, int y) {
		boolean visit[][] = new boolean[h][w];
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(x, y, 0));
		visit[y][x] = true;
		
		int hour = 0; 
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			hour = p.hour;
			
			for(int i=0; i<4; i++) {
				int tempX = dx[i] + p.x;
				int tempY = dy[i] + p.y;
				
				if(tempX>=0 && tempX<w && tempY>=0 && tempY<h && map[tempY][tempX] == 'L' && visit[tempY][tempX] == false) {
					visit[tempY][tempX] = true;
					queue.add(new Point(tempX, tempY, p.hour+1));
				}
			}
			
		}
		
		result = Math.max(result, hour);
		
	}
	
}

class Point {
	int x;
	int y;
	int hour;
	
	public Point(int x, int y, int hour) {
		this.x = x;
		this.y = y;
		this.hour = hour;
	}
}
