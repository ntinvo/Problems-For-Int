public class LinkedListRemoveDup {

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;

		for (int i = 0; i < 8; i++) {
			second = new LinkedListNode(i + 1, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		second = new LinkedListNode(0, null, null);
		first.setNext(second);
		second.setPrevious(first);
		first = second;

		System.out.println(head.printForward());
		removeDup(head);
		System.out.println(head.printForward());
	}


	public static void removeDup(LinkedListNode n) {
		LinkedListNode current = n;
		LinkedListNode runner = current.next;
		while(current != null) {
			LinkedListNode prev = current;
			while(runner != null) {
				if(runner.data == current.data) {
					runner = runner.next;
					prev.next = runner;
				} else {
					prev = runner;
					runner = runner.next;
				}
			}
			current = current.next;
			if (current != null) {
				runner = current.next;
			}
		}
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