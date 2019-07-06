package stack_queue;

// 배열로 구현할 때 큐의 시작지점과 끝부분을 잘 고려해야함.
// 지정한 크기의 하나를 사용하지 못하므로 크기를 1크게 해줘야함
public class QueueArray {
	
	int front;
	int last;
	int size;
	Object arr[];
	
	public QueueArray(int size) {
		this.size = size+1;
		arr = new Object[size];
		front = 0;
		last = front;
	}
	
	public boolean isEmpty() {
		return (front == last);
	}
	
	public boolean isFull() {
		if((last+1) % size == front) return true;
		else return false;
	}
	
	public void enqueue(Object o) {
		if(isFull()) {
			return;
		}
		else {
			arr[last++] = o;
			
			if(last == size) last = last % size;
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			return new ArrayIndexOutOfBoundsException();
		}
		else {
			Object val = arr[front++]; 
			if(front == size) front = front % size;
			
			return val;
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			return new ArrayIndexOutOfBoundsException();
		}
		else {
			return arr[front];
		}
	}
}
