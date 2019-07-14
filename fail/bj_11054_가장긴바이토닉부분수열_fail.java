package fail;

// LIS(최장증가수열)를 이용하는 문제
// 기준값의 앞부분의 LIS와 뒷부분의 역순배열의 LIS을 가지고 구할 수 있다.
// 2631문제 풀어보기 기본 LIS문제

import java.util.Scanner;

public class bj_11054_가장긴바이토닉부분수열_fail {
	static final int ORIGIN = 0;
	static final int REVERSE = 1;
	
	static int dp[][];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int max = Integer.MIN_VALUE;
		int n = scan.nextInt();
		
		int s[] = new int[n+1];
		
		dp = new int[2][n+1];
		
		for(int i=1; i<=n; i++) 
			s[i] = scan.nextInt();
		
		int rs[] = reverseArray(s);
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				if(s[j] < s[i]) {
					dp[ORIGIN][i] = Math.max(dp[ORIGIN][i], dp[ORIGIN][j] + 1);
				}
				if(rs[j] < rs[i]) {
					dp[REVERSE][i] = Math.max(dp[REVERSE][i], dp[REVERSE][j] + 1);
				}
			}
		}
		
//		for(int i=0; i<=1; i++) {
//			for(int j=1; j<=n; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int i=1; i<=n; i++) {
			max = Math.max(max, dp[ORIGIN][i] + dp[REVERSE][n-i+1] - 1);
		}
		
		System.out.println(max);
	}
	
	static int[] reverseArray(int[] array) {
		int len = array.length;
		int result[] = new int[len];
		
		for(int i=1; i<len; i++)
			result[i] = array[len-i]; 
		
		return result;
	}
	
}
