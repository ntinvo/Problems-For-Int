import java.util.*;

class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = {9, 5, 1, 8, 3, 0, 6, 7, 2, 4};
		toString(arr);
		selectionSort(arr);
		toString(arr);
		selectionSortReverse(arr);
		toString(arr);
	}

	public static void toString(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void selectionSort(int[] arr) {
		int runner;
		for (int i = 0; i < arr.length; i++) {
			runner = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if(runner > arr[j]) {
					int temp = arr[j];
					arr[j] = runner;
					runner = temp;
				}
			}
			arr[i] = runner;
		}
	}

	public static void selectionSortReverse(int[] arr) {
		int runner;
		for (int i = 0; i < arr.length; i++) {
			runner = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if(runner < arr[j]) {
					int temp = arr[j];
					arr[j] = runner;
					runner = temp;
				}
			}
			arr[i] = runner;
		}
	}
}