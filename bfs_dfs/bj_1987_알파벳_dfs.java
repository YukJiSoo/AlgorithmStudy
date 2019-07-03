package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// DFS + 백트래킹
// 방문이력을 유지해야 함
// 백트래킹?
// 백트래킹이 어려운 개념이 아니었다. 알고보면 간단한 문제였음
// 처음에 접근방향은 맞았었지만 확신이 서지 않아서 시간이 꽤 걸렸던 문

public class bj_1987_알파벳_dfs {

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	
	static boolean visit[] = new boolean[26]; // 알파벳 방문 배열
	static int board[][];
	
	static int r, c;
			
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		r = scan.nextInt();
		c = scan.nextInt();
		
		board = new int[r][c];
		
		for(int i=0; i<r; i++) {
			String inputLine = scan.next();
			
			for(int j=0; j<c; j++) {
				board[i][j] = inputLine.charAt(j) - 'A';
			}
		}
		
		visit[board[0][0]] = true;
		System.out.println(DFS(0,0));
		
	}
	
	static int DFS(int x, int y) {
		int tempX, tempY;
		
		int maxCnt = 0;
		 
		for(int i=0; i<4; i++) {
			tempX = x+dx[i];
			tempY = y+dy[i];
			
			if(tempX >= 0 && tempX < c && tempY >= 0 && tempY < r && visit[board[tempY][tempX]] == false) {
				int index = board[tempY][tempX];
				
				visit[index] = true;
				maxCnt = Math.max(maxCnt, DFS(tempX, tempY));
				visit[index] = false;
			}

		}
		
		return maxCnt+1;
	}
}
