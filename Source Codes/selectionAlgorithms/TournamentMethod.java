package selectionAlgorithms;

public class TournamentMethod {
    int min;
    int max;

    public TournamentMethod getMinMax(int a[], int low, int high) {
	TournamentMethod minMax = new TournamentMethod();
	TournamentMethod mml = new TournamentMethod();
	TournamentMethod mmr = new TournamentMethod();
	int mid;
	if (low == high) {
	    minMax.min = a[low];
	    minMax.max = a[low];
	    // System.out.println("Smallest : " + " " + minMax.min);
	    // System.out.println("Largest : " + " " + minMax.max);
	    return minMax;
	}
	if (high == low + 1) {
	    if (a[low] > a[high]) {
		minMax.min = a[high];
		minMax.max = a[low];
	    } else {
		minMax.min = a[low];
		minMax.max = a[high];
	    }
	    // System.out.println("Smallest : " + " " + minMax.min);
	    // System.out.println("Largest : " + " " + minMax.max);
	    return minMax;
	}
	mid = (low + high) / 2;
	mml = getMinMax(a, low, mid);
	mmr = getMinMax(a, mid + 1, high);
	if (mml.min < mmr.min) {
	    minMax.min = mml.min;
	} else {
	    minMax.min = mmr.min;
	}
	if (mml.max > mmr.max) {
	    minMax.max = mml.max;
	} else {
	    minMax.max = mmr.max;
	}
	// System.out.println("Smallest : " + " " + minMax.min);
	// System.out.println("Largest : " + " " + minMax.max);
	return minMax;
    }
}
