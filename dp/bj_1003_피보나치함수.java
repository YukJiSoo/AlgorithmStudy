package dp;

import java.util.Scanner;

public class bj_1003_피보나치함수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int n[] = new int[t];
		for(int i=0; i<t; i++) n[i] = scan.nextInt();
		
		Fibonacci dp[] = new Fibonacci[41];
		
		for(int i=0; i<=40; i++) {
			if(i==0) dp[i] = new Fibonacci(1,0);
			else if(i==1) dp[i] = new Fibonacci(0,1);
			else {
				int zeroNum = dp[i-1].zeroNum + dp[i-2].zeroNum;
				int oneNum = dp[i-1].oneNum + dp[i-2].oneNum;
				
				dp[i] = new Fibonacci(zeroNum, oneNum);
			}
		}
		
		for(int i=0; i<t; i++) 
			System.out.println(dp[n[i]].zeroNum + " " + dp[n[i]].oneNum);
		
	}

}

class Fibonacci {
	int zeroNum;
	int oneNum;
	
	public Fibonacci(int zeroNum, int oneNum) {
		this.zeroNum = zeroNum;
		this.oneNum = oneNum;
	}	
	
}