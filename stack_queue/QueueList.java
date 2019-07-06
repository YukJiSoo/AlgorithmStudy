package stack_queue;

public class QueueList {
	
	Node_q head;
	Node_q rear;
	
	public QueueList() {
		head = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void enqueue(Object o) {
		Node_q node = new Node_q(o, null);
		
		if(isEmpty()) {
			head = node;
			rear = node;
		}
		else {
			rear.next = node;
			rear = node;
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			return new NullPointerException();
		}
		else {
			Node_q node = head;
			head = head.next;
			
			if(head == null) rear = null;
			return node.o;
		}
	}
	
	public Object peek() {
		if(isEmpty()) {
			return new NullPointerException();
		}
		else {
			
			return head.o;
		}
	}
}

class Node_q {
	
	Object o;
	Node_q next;
	
	public Node_q(Object o, Node_q next) {
		this.o = o;
		this.next = null;
	}
}
