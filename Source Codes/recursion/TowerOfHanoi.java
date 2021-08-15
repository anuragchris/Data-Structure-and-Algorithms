package recursion;

public class TowerOfHanoi {
    public void towerOfHanoi(int n, char source, char destination, char auxillary) {
	if (n == 1) {
	    System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
	    return;
	}
	towerOfHanoi(n - 1, source, auxillary, destination);
	System.out.println("Move disk " + n + " to rod " + destination);
	towerOfHanoi(n - 1, auxillary, destination, source);
    }
}
