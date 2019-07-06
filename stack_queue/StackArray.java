package stack_queue;

public class StackArray {
	
	private Object array[];
	private int top;
	private int size;
	
	public StackArray(int size) {
		this.top = -1;
		this.size = size;
		this.array = new Object[size];
	}
	
	public boolean isEmpty() {
		return array.length == 0 ? true : false;  
	}
	
	public boolean isFull() {
		return array.length == size ? true : false;  
	}
	
	public void push(Object o) {
		if(isFull()) throw new ArrayIndexOutOfBoundsException();
		array[++top] = o;
		
	}
	
	public Object pop() {
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
		return array[top--];
	}
	
	public Object peek() {
		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
		return array[top];
	}

}
