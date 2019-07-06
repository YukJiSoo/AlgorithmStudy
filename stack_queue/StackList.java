package stack_queue;

public class StackList {
	Node head;
	
	public StackList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;  
	}
	
	public void push(Object o) {
		
		Node node = new Node(o, null);
		node.next = head;
		
		head = node;
	}
	
	public Object pop() {
		if(isEmpty()) new NullPointerException();
		
		Node temp = head;
		head = temp.next;
		
		Object returnNode = temp.o;
		
		return returnNode;
	}
	
	public Object peek() {
		return head.o;
	}
	
}

class Node {
	
	Object o;
	Node next;
	
	public Node(Object o, Node next) {
		this.o = o;
		this.next = next;
	}
}
