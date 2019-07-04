package greedy;

/* 그리디
 * 남학생이 최대한 다 써야 많은 팀이 생성
 * 1. 남학생을 다쓰고 꾸릴 수 있는 최대 팀의 개수를 가정
 * 2. 남은 남학생과 여학생에서 인턴쉽 참여인원을 충
 * 3. 인턴쉽 학생이 부족하면 팀을 하나씩 해체시킴 - 3명의 학생사용가능
 */

import java.util.Scanner;

public class bj_2875_대회or인턴 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		
		
		int teamNum = m;
		while(n < teamNum*2) {
			teamNum -= 1;
		}
		
		int leftStudent = (n-2*teamNum)+(m-teamNum);
		while(leftStudent < k) {
			teamNum -= 1;
			leftStudent += 3;
		}
		
		System.out.println(teamNum >= 0 ? teamNum : 0);
	}
}
