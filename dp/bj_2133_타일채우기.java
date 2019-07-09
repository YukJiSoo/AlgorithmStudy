package dp;

// 규칙을 파악하고 점화식을 세워야함
// 가로의 길이가 2씩 증가함에 따라 특별한 타일 유형이 2개씩 추가됨
// 그전에 배치한 타일의 유형에 대한 경우의 수를 이용

import java.util.Scanner;

public class bj_2133_타일채우기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int dp[] = new int[n+1];
		
		if(n%2 == 1) {
			System.out.println("0");
			return;
		}
		dp[0] = 1;
		dp[2] = 3;
		
		for(int i=4; i<=n; i+=2) {
			for(int j=2; j<=i; j+=2) {
				int temp = j == 2 ? 3 : 2;
				dp[i] += dp[i-j] * temp;
			}
			
		}
		
		System.out.println(dp[n]);
	}

}
