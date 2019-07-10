package dp;

import java.util.Scanner;

public class bj_2294_동전2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		int coins[] = new int[n];
		int dp[] = new int[k+1];
		
		for(int i=0; i<n; i++) {
			coins[i] = scan.nextInt();
		}
		
		for(int i=1; i<=k; i++) {
			dp[i] = Integer.MAX_VALUE;
			
			for(int j=0; j<n; j++) {
				
				int coin = coins[j];
				if(i-coin >= 0 && dp[i-coin] != -1 && dp[i] > dp[i-coin]+1) {
					dp[i] = dp[i-coin]+1;
				}
			}
			
			if(dp[i] == Integer.MAX_VALUE) dp[i] = -1;
		}

		System.out.println(dp[k]);
	}

}
