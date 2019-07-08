package string;

import java.util.Arrays;
import java.util.Scanner;

public class bj_1545_안티팰린드롬 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String s = scan.next();
		
		char p[] = s.toCharArray();
		Arrays.sort(p);
		
		// 안티팰린드롬 아닌 문자열 만들기
		int n = p.length;
		int start = n%2 == 1 ? (n-1)/2 + 1 : (n-1)/2;
		
		int cnt = 0;
		for(int i=start; i<n; i++) {
			if(p[i] != p[n-i-1]) break;
			cnt++;
		}
		
		if(cnt != 0) {
			// 1. 뒤에 있는 것들 뒤에서 가져다 쓰기
			for(int i=start+cnt; i<n; i++) {
				if(cnt == 0) break;
				
				char temp = p[i];
				p[i] = p[i-cnt];
				p[i-cnt] = temp;
				
				cnt -= 1;
			}
		}
		
		
//		// 안티팰린드롬 문자열 만들기
//		int n = p.length;
//		int start = 0;
//		int mid = (n-1)/2;
//		int end = n-1;
//		
//		int indexL = -1;
//		int indexR = -1;
//		for(int i=mid; i>start; i--) {
//			if(p[i] == p[i-1]) indexL = i-1;
//		}
//		
//		// 문자열의 길이가 짝과홀인경우에 따라 중간값의 시작위치가 달라짐
//		mid = n%2 == 1 ? mid : mid+1;
//		
//		for(int i=mid; i<end; i++) {
//			if(p[i] == p[i+1]) indexR = i;
//		}
//		
//		// indexR 부분을 교체 : 큰수가 뒤에 오는 것이 사전 순으로 앞
//		if(indexL + 1 < n-indexR) {
//			char temp = p[indexR+1];
//			p[indexR+1] = p[n-indexR-1]; 
//			p[n-indexR-1] = temp;
//		}
//		else {
//			char temp = p[indexL+1];
//			p[indexL+1] = p[n-indexL-1]; 
//			p[n-indexL-1] = temp;
//		}
		
		System.out.println(p);
	}
}
