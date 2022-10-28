package binarySearch;

public class RowAndColumnWiseSortedMatrix {
	static int search(int arr[][], int element) {
		int i = 0, j = arr[0].length - 1;
		while ((i >= 0 && i < arr.length) && (j >= 0 && j < arr[0].length)) {
			if (arr[i][j] == element) {
				System.out.println("(" + i + "," + j + ")");
				return 1;
			} else if (arr[i][j] > element)
				j--;
			else if (arr[i][j] < element)
				i++;
		}
		System.out.println("Not Found");
		return -1;
	}

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		search(mat, 29);
	}
}
