public class sumlists {

	/* NOTE THAT FOR THE REVERSE CASE, I HAVEN'T TAKEN INTO
	ACCOUNT THE LENGTH OF THE TWO LISTS ARE NOT THE SAME */

	public static void main(String[] args) {
		/* First num */
		LinkedListNode first1 = new LinkedListNode(7, null, null);
		LinkedListNode head1 = first1;
		LinkedListNode second1 = first1;

		
		second1 = new LinkedListNode(1, null, null);
		first1.setNext(second1);
		second1.setPrevious(first1);
			first1 = second1;

		second1 = new LinkedListNode(6, null, null);
		first1.setNext(second1);
		second1.setPrevious(first1);
			first1 = second1;

		second1 = new LinkedListNode(8, null, null);
		first1.setNext(second1);
		second1.setPrevious(first1);
			first1 = second1;

		second1 = new LinkedListNode(2, null, null);
		first1.setNext(second1);
		second1.setPrevious(first1);
			first1 = second1;

		second1 = new LinkedListNode(1, null, null);
		first1.setNext(second1);
		second1.setPrevious(first1);
			first1 = second1;

		/* Second num */
		LinkedListNode first2 = new LinkedListNode(5, null, null);
		LinkedListNode head2 = first2;
		LinkedListNode second2 = first2;

		
		second2 = new LinkedListNode(9, null, null);
		first2.setNext(second2);
		second2.setPrevious(first2);
			first2 = second2;

		second2 = new LinkedListNode(5, null, null);
		first2.setNext(second2);
		second2.setPrevious(first2);
			first2 = second2;

		second2 = new LinkedListNode(2, null, null);
		first2.setNext(second2);
		second2.setPrevious(first2);
			first2 = second2;

		
		System.out.println("First num: " + head1.printForward());
		System.out.println("Second num: " + head2.printForward());
		LinkedListNode sum1 = sumlist(head1, head2);
		System.out.println("Sum First and Second is: " + (sum1.printForward()));

		System.out.println("---------------------------");

		/* Third num */
		LinkedListNode first3 = new LinkedListNode(6, null, null);
		LinkedListNode head3 = first3;
		LinkedListNode second3 = first3;

		second3 = new LinkedListNode(1, null, null);
		first3.setNext(second3);
		second3.setPrevious(first3);
			first3 = second3;

		second3 = new LinkedListNode(7, null, null);
		first3.setNext(second3);
		second3.setPrevious(first3);
			first3 = second3;

		/* Fourth num */
		LinkedListNode first4 = new LinkedListNode(2, null, null);
		LinkedListNode head4 = first4;
		LinkedListNode second4 = first4;

		second4 = new LinkedListNode(9, null, null);
		first4.setNext(second4);
		second4.setPrevious(first4);
			first4 = second4;

		second4 = new LinkedListNode(5, null, null);
		first4.setNext(second4);
		second4.setPrevious(first4);
			first4 = second4;


		System.out.println("Third num: " + head3.printForward());
		System.out.println("Fourth num: " + head4.printForward());
		LinkedListNode sum2 = sumlistReverse(head3, head4);
		System.out.println("Sum Third and Fourth is: " + (sum2.printForward()));
	}

	public static LinkedListNode sumlistReverse(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode first = null;
		LinkedListNode ret = first;
		LinkedListNode second = first;

		LinkedListNode runner1 = head1;
		LinkedListNode runner2 = head2;
		LinkedListNode current = null;

		int count = 0;

		while(runner1 != null && runner2 != null) {
			int temp = runner1.data + runner2.data;
			if(count == 0) {
				if(temp >= 10) {
					first = new LinkedListNode(temp / 10, null, null);
					ret = first;
					second = first;

					second = new LinkedListNode(temp % 10, null, null);
					first.setNext(second);
					second.setPrevious(first);
					first = second;
					current = second;
				} else {
					first = new LinkedListNode(temp, null, null);
					ret = first;
					second = first;
					current = second;
				}
			} else {
				if(temp >= 10) {
					current.data += temp / 10;
				}
				second = new LinkedListNode(temp % 10, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;
				current = second;
			}

			runner1 = runner1.next;
			runner2 = runner2.next;
			count++;
		}

		return ret;
	}

	public static LinkedListNode sumlist(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode first = null;
		LinkedListNode ret = first;
		LinkedListNode second = first;

		LinkedListNode runner1 = head1;
		LinkedListNode runner2 = head2;

		int remain = 0;
		int count = 0;

		while(runner1 != null && runner2 != null) {
			int temp = runner1.data + runner2.data + remain;
			int data = temp % 10;
			remain = temp / 10;
			if(count == 0) {
				first = new LinkedListNode(data, null, null);
				ret = first;
				second = first;
				count++;
			} else {
				second = new LinkedListNode(data, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;
			}
			runner1 = runner1.next;
			runner2 = runner2.next;
		}

		if(runner1 == null && runner2 != null) {
			while(runner2 != null) {
				int temp = remain + runner2.data;
				int data = temp % 10;
				remain = temp / 10;
				second = new LinkedListNode(data, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;
				runner2 = runner2.next;
			}
		}

		if(runner1 != null && runner2 == null) {
			while(runner1 != null) {
				int temp = remain + runner1.data;
				int data = temp % 10;
				remain = temp / 10;
				second = new LinkedListNode(data, null, null);
				first.setNext(second);
				second.setPrevious(first);
				first = second;
				runner1 = runner1.next;
			}
		}


		return ret;
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