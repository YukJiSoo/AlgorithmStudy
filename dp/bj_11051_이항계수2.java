package dp;

import java.util.Scanner;

public class bj_11051_이항계수2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();

		int dp[][] = new int[n+1][n+1];
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = 1;
			dp[i][n] = 1;
			
			for(int j=1; j<n; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
			}
		}

		System.out.println(dp[n][k] % 10007);
		
//		int result = 1;
//		for(int i=1; i<=n; i++) result *= i;
//		for(int i=1; i<=k; i++) result /= i;
//		for(int i=1; i<=n-k; i++) result /= i;
//		System.out.println(result);
	}

}
