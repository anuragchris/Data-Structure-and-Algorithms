package bitManipulation;

public class MajorityElement {
	static int majorityElement(int arr[]) {
		int number = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) != 0)
					count++;
			}
			if (count > arr.length / 2)
				number += (1 << i);
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == number)
				count++;
		}
		if (count > arr.length / 2)
			return number;
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		System.out.println(majorityElement(arr));
	}
}
