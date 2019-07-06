package sort;

// 리스트의 끝까지 돌면서 최소값/최대값을 가지는 인덱스를 저장하고
// 리스트 맨 앞의 값과 교체
// 단순하지만 비효율적
// O(n^2)의 시간복잡도

public class selection_sort {
	public static void main(String[] args) {
		int arr[] = new int[] {9,1,6,8,4,3,2,0};
		
		selectionSort(arr);
		
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]);
	}
	
	static void selectionSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			
			int minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[minIndex] > arr[j]) minIndex = j;
			}
			
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
}
