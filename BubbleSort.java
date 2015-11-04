import java.util.*;

class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {9, 5, 1, 8, 3, 0, 6, 7, 2, 4};
		toString(arr);
		bubbleSort(arr);
		toString(arr);
		bubbleSortReverse(arr);
		toString(arr);
	}

	public static void toString(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void bubbleSort(int[] arr) {
		int limit = arr.length;

		while(limit > 0) {

			for (int i = 0; i < limit - 1; i++) {
				if(arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			limit--;
		}
	}

	public static void bubbleSortReverse(int[] arr) {
		int limit = arr.length;

		while(limit > 0) {

			for (int i = 0; i < limit - 1; i++) {
				if(arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			limit--;
		}
	}
}