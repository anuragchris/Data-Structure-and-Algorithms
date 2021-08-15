package searching;

public class Implement {
    public static void main(String Args[]) {
	// 1.Linear Search
	// int a[] = { 2, 4, 5, 7, 8, 9, 11, 2, 33, 44, 66 };
	// int element = 0;
	// LinearSearch ls = new LinearSearch();
	// ls.linearSearch(a, element);

	// 2.Binary Search
	// int a[] = { 2, 4, 6, 8, 10 };
	// int element = 6;
	// int left = 0;
	// int right = a.length - 1;
	// BinarySearch bs = new BinarySearch();
	// System.out.println(bs.iterative(a, element));
	// System.out.println(bs.recursive(a, left, right, element));

	// 3.Interpolation Search
	// int a[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	// int element = 8;
	// InterpolationSearch is = new InterpolationSearch();
	// System.out.println(is.interpolationSearch(a, element));

	// 4.Duplicate Elements
	// int a[] = { 1, 1, 1, 1, 1, 2, 2, 2 };
	// DuplicateElement de = new DuplicateElement();
	// System.out.println(de.duplicatesUsingSort(a));

	// 5.Maximum Frequency
	// int a[] = { 1, 2, 3 };
	// MaximnumFrequency mf = new MaximnumFrequency();
	// System.out.println(mf.maxFrequency(a));

	// 6.Missing Number
	// int a[] = { 1, 2, 3, 5, 6, 7 };
	// MissingNumber mn = new MissingNumber();
	// System.out.println(mn.usingSum(a));
	// System.out.println(mn.usingXOR(a));

	// 7.Number Occuring Odd Number of Times
	int a[] = { 1, 2, 2, 1, 1, 1, 2, };
	NumberOccuringOddTimes ot = new NumberOccuringOddTimes();
	System.out.println(ot.usingXOR(a));

	// 8.Number Occuring Once while Others Occuring Thrice
	// int a[] = { 3, 3, 2, 3, 1, 1, 1 };
	// NumberOccuringOnce noo = new NumberOccuringOnce();
	// System.out.println(noo.usingXOR(a));

	// 9.Elements Whose Sum is Equal to K
	// int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	// int k = 13;
	// SumEqualToK setk = new SumEqualToK();
	// setk.usingSort(a, k);

	// int a[] = { 1, 60, -10, 70, -80, 85 };
	// SumClosestToZero sctz = new SumClosestToZero();
	// sctz.usingSort(a, a.length);
    }
}
