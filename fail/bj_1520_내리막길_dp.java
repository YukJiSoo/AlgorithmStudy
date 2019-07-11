package fail;

import java.util.Scanner;

// bfs로 풀면 메모리 초과이다.
// dfs로 풀면 시간 초과이다.
// 가능한 경우의 수를 따져보면 시간초과와 메모리초과가 일어날 수 밖에 없기때문에
// dp로 풀자 + dfs를 첨가하자
public class bj_1520_내리막길_dp {
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static int m, n;
	static int map[][];
	static int dp[][];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// input
		m = scan.nextInt();
		n = scan.nextInt();
		map = new int[m][n];
		
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) map[i][j] = scan.nextInt();
		
		// dp
		dp = new int[m][n];
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) dp[i][j] = -1;
		
		System.out.println(dfs(n-1, m-1));
	}
	
	static int dfs(int x, int y) {
		if(dp[y][x] != -1) return dp[y][x];
		if(x == 0 && y == 0) return 1;
		
		dp[y][x] = 0;
		for(int i=0; i<4; i++) {
			int tempX = dx[i] + x;
			int tempY = dy[i] + y;
			
			if(tempX >= 0 && tempX < n && tempY >= 0 && tempY < m)
				if(map[y][x] < map[tempY][tempX]) {
					dp[y][x] += dfs(tempX, tempY);
				}
			
		}
		
		return dp[y][x];
	}
}
