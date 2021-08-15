package selectionAlgorithms;

public class Implement {
    public static void main(String[] args) {
	int a[] = { 2, 6, 8, 9, 1, 100, 100000, 24535123, 343 };
	// SmallestAndLargest sl = new SmallestAndLargest();
	// sl.findLargestElement(a);
	// sl.smallestAndLargest(a);
	// sl.smallestAndLargestWithComparison(a);

	// TournamentMethod tm = new TournamentMethod();
	// tm = tm.getMinMax(a, 0, a.length - 1);
	// System.out.println(tm.min);
	// System.out.println(tm.max);

	KthSmallest ks = new KthSmallest();
	System.out.println(ks.kthSmmallest(a, 0, a.length - 1, 4));

    }
}
