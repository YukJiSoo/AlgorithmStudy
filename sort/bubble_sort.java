package sort;

// 서로 인접한 두수를 검사하여 정렬하는 알고리즘
// 배열의 끝부분부터 정렬해 나감
// O(n^2)의 시간복잡도
// 이미 알맞은 자리에 있는 경우에도 원소간의 교환이 일어날 수 있음

public class bubble_sort {
	public static void main(String[] args) {
		int arr[] = new int[] {9,1,6,8,4,3,2,0};
		
		bubbleSort(arr);
		
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]);
	}
	
	static void bubbleSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			
			for(int j=0; j<arr.length-i; j++) {
				
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
