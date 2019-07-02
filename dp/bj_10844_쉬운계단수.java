package dp;

import java.util.Scanner;

public class bj_10844_쉬운계단수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int dp[][] = new int[n+1][10];
		
		for(int num=1; num<10; num++) {
			dp[1][num] = 1;
		}
		
		for(int step=2; step<=n; step++) {
			for(int num=0; num<10; num++) {
				if(num > 0) dp[step][num] = (dp[step][num] + dp[step-1][num-1])%1000000000;
				if(num < 9) dp[step][num] = (dp[step][num] + dp[step-1][num+1])%1000000000;
			}
		}
		
		int sum = 0;
		for(int num=0; num<10; num++) {
			sum = (sum + dp[n][num])%1000000000;
		}
		
		System.out.println(sum%1000000000);
	} 
}
