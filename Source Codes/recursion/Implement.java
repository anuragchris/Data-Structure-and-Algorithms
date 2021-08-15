package recursion;

import java.io.IOException;

public class Implement {
    public static void main(String args[]) throws IOException {
	TowerOfHanoi toh = new TowerOfHanoi();
	int n = 3; // Number of disks
	toh.towerOfHanoi(n, 'A', 'B', 'C');

	// CheckArraySort array = new CheckArraySort();
	// int check[] = { 2, 1, 4, 5, 6 };
	// int m = check.length;
	// int a = array.checkArraySort(check, m);
	// System.out.println(a);
    }
}
