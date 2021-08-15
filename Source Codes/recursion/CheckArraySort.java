package recursion;

import java.util.ArrayList;
import java.util.List;

public class CheckArraySort {
	public int checkArraySort(int arr[], int n) {
		if (n == 1 || n == 0) {
			return 1;
		}
		if (arr[n - 1] < arr[n - 2]) {
			return 0;
		} else {
			return checkArraySort(arr, n - 1);
		}
	}

	static void sortArray(List<Integer> ls, int n) {
		if (ls.size() == 1) {
			return;
		}
//		if (arr.length == 1) {
//			return;
//		}
		int temp = ls.get(ls.size() - 1);
		ls.remove(ls.size() - 1);
		sortArray(ls, ls.size());
		insert(ls, temp);
	}

	static void insert(List<Integer> ls, int temp) {
		if (ls.size() == 0 || ls.get(ls.size() - 1) <= temp) {
			ls.add(temp);
			return;
		}
		int val = ls.get(ls.size() - 1);
		ls.remove(ls.size() - 1);
		insert(ls, temp);
		ls.add(val);
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(5);
		al.add(100);
		al.add(1);
		System.out.println(al);
		sortArray(al, al.size());
		System.out.println(al);
	}
}
