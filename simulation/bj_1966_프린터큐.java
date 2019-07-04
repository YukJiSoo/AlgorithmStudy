package simulation;
/* 시뮬레이션
 * 단순히 큐에 저장된 프린트 문서를 전부 비교하면서 진행 - 최선의 방법인지?
 *
 * 우선순위 큐와 일반적인 큐 두개를 사용하여 문제를 풀수도 있다
 * -> 처음에 생각했던 방법과 비슷하지만 구현을 하지는 않았다.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1966_프린터큐 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testCase = scan.nextInt();
		
		int result[] = new int[testCase];
		for(int t=0; t<testCase; t++) {
			
			int n = scan.nextInt();
			int m = scan.nextInt();
			
			Queue<Docs> docs = new LinkedList<Docs>();
			for(int i=0; i<n; i++) {
				docs.add(new Docs(i, scan.nextInt()));
			}
			
			int cnt = 0;
			boolean flag = true;
			while(!docs.isEmpty()) {
				Docs fd = docs.peek();
				
				for(Docs td: docs) {
					if(fd.priority < td.priority) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(docs.poll().num == m) {
						result[t] = cnt;
						break;
					}
				}
				else {
					Docs pop = docs.poll();
					docs.add(pop);
				}
				
				flag = true;
			}
			
			
		}
		
		for(int r: result) {
			System.out.println(r);
		}
		
  	}

}

class Docs {
	int num;
	int priority;
	
	public Docs(int num, int priority) {
		this.num = num;
		this.priority = priority;
	}
}
