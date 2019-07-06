package sort;

// 배열의 두번째 값부터 정렬을 시작한다.
// 비교할 값의 앞 부분은 이미 정렬되어있는 부분이다.
// 이미 정렬되어 있는 부분에 해당 원소를 알맞은 자리에 삽입
// 정렬된 부분의 뒷부분도 비교를 시작 - 확인 후 교환할 필요가 없다면 다음 자료로 바로 넘어감
// 최악 시간복잡도 O(n^2) : 모든 경우의 수에서 교환작업까지 하는 경우
// 최선 시간복잡도 O(n) : 모든 경우의 수에서 비교만 하고 넘어가는 경우

public class insertion_sort {
	
	public static void main(String[] args) {
		int arr[] = new int[] {9,1,6,8,4,3,2,0};
		
		insertionSort(arr);
		
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]);
	}
	
	static void insertionSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			
			int index = i;
			for(int j=i-1; j>=0; j--) {
				if(arr[j] > arr[index]) {
					int temp = arr[index];
					arr[index--] = arr[j];
					arr[j] = temp;
				}
				else break;
			}

		}
	}
}
