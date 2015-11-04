import java.util.*;

public class palindromeLinkedList {

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(1, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;

		
		second = new LinkedListNode(2, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(3, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(4, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(5, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(5, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(4, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(3, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(2, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		second = new LinkedListNode(1, null, null);
		first.setNext(second);
		second.setPrevious(first);
			first = second;

		System.out.println(head.printForward());
		if(palindrome(head)) {
			System.out.println("The LinkedList is palindrome");
		} else {
			System.out.println("The LinkedList is not palindrome!!!");
		}
	}


	public static boolean palindrome(LinkedListNode head) {
		LinkedListNode current = head;
		LinkedListNode runner = head;
		
		Stack<Integer> st = new Stack<Integer>();

		while(runner != null && runner.next != null) {
			st.push(current.data);
			current = current.next;
			runner = runner.next.next;
		}

		if(runner != null)
			current = current.next;

		while(current != null) {
			if(current.data != st.pop().intValue())
				return false;
			current = current.next;
		}

		return true;
	}


	/*****************************************************************/
	/* LINKEDLISTNODE FROM CRACKING THE CODING INTERVIEW 6TH EDITION */
	/*****************************************************************/
	public static class LinkedListNode {
		public LinkedListNode next;
		public LinkedListNode prev;
		public LinkedListNode last;
		public int data;

		public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
			data = d;
			setNext(n);
			setPrevious(p);
		}
		
		public LinkedListNode(int d) {
			data = d;
		}	
		
		public LinkedListNode() { }

		public void setNext(LinkedListNode n) {
			next = n;
			if (this == last) {
				last = n;
			}
			if (n != null && n.prev != this) {
				n.setPrevious(this);
			}
		}
		
		public void setPrevious(LinkedListNode p) {
			prev = p;
			if (p != null && p.next != this) {
				p.setNext(this);
			}
		}	
		
		public String printForward() {
			if(next == null)
				return "[" + data + "]";

			if (next != null) {
				return "[" + data + "]" + "->" + next.printForward();
			} else {
				return ((Integer) data).toString();
			}
		}
		
		public LinkedListNode clone() {
			LinkedListNode next2 = null;
			if (next != null) {
				next2 = next.clone();
			}
			LinkedListNode head2 = new LinkedListNode(data, next2, null);
			return head2;
		}
	}
}