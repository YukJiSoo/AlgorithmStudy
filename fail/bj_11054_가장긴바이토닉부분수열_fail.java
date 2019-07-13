package fail;


// LIS(최장증가수열)를 이용하는 문제
// 기준값의 앞부분의 LIS와 뒷부분의 역순배열의 LIS을 가지고 구할 수 있다.
// 2631문제 풀어보기 기본 LIS문제

import java.util.Scanner;

public class bj_11054_가장긴바이토닉부분수열_fail {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int sequence[] = new int[n];
		
		for(int i=0; i<n; i++) sequence[i] = scan.nextInt();
		
		
	}
	
	static int LIScount(int[] sequence) {
		int len = sequence.length;
		int dp[] = new int[len+1];
		
		return 1;
	}
}
