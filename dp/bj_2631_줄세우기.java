package dp;

// LIS 문제

import java.util.Scanner;

public class bj_2631_줄세우기 {
	
	static int dp[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int kids[] = new int[n+1];
		dp = new int[n+1];
		for(int i=1; i<=n; i++) kids[i] = scan.nextInt();
		
		int max = Integer.MIN_VALUE;
		
		// 1. O(n^2) 방법
//		for(int i=1; i<=n; i++) {
//			for(int j=0; j<i; j++) {
//				if(kids[j] < kids[i] && dp[j] >= dp[i]) 
//					dp[i] = dp[j] + 1;
//			}
//			
//			max = Math.max(max, dp[i]);
//		}
		
		// 2. O(nlogn) 방법
		
		int index = 0;
		for(int i=1; i<=n; i++) {
			if(dp[index] <= kids[i]) {
				dp[++index] = kids[i];
			}
			else {
				int insertIndex = binarySearch(kids[i], index);
				dp[insertIndex] = kids[i];
			}
		}
		
		System.out.println(n-index);
	}
	
	static int binarySearch(int target, int end) {
		int mid;
		int start = 1;
		
		while(start < end) {
			mid = (start+end)/2;
			
			if(target <= dp[mid]) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		
		return end;
	}
	
}
