package string;

import java.util.Scanner;

// 알파벳에 대한 출현 빈도를 기억하는 배열을 생성
public class bj_1157_단어공부 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.next();
		int alphabetCnt = 'z'-'a'+1;
		int lowerUpperGap = Math.abs('A'-'a');
		
		int[] alphabets = new int[alphabetCnt];
		
		for(int i=0; i<str.length(); i++) {
			int alphabetIndex = str.charAt(i) - 'a'; 
			if(alphabetIndex < 0) alphabetIndex += lowerUpperGap;
			
			alphabets[alphabetIndex] += 1;
		}
		
		boolean duplicationFlag = false;
		int max = 0;
		
		for(int i=1; i<alphabets.length; i++) {
			if(alphabets[i] > alphabets[max]) {
				duplicationFlag = false;
				max = i;
			}
			else if(alphabets[i] == alphabets[max]) duplicationFlag = true; 
		}
		
		System.out.println(duplicationFlag ? "?" : (char)(max+'A'));
	}

}
