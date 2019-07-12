package dp;

import java.util.Scanner;

public class bj_1890_점프 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int board[][] = new int[n][n];
		long dp[][] = new long[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = scan.nextInt();
			}
		}
		
		dp[0][0] = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dp[i][j] == 0 || (i == n-1 && j == n-1)) continue;
				
				int distance = board[i][j];
				int right = j+distance;
				int down = i+distance;
				
				if(right < n) dp[i][right] += dp[i][j];
				if(down < n) dp[down][j] += dp[i][j];
			}
		}
		
		
		System.out.println(dp[n-1][n-1]);
	}
	
}
