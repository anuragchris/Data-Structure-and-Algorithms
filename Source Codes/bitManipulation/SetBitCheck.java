package bitManipulation;

public class SetBitCheck {
	public static void main(String[] args) {
		int n = 12, i = 3;
		int k = 1;
		k <<= i;
		int check = n & k;
		if (check == 0)
			System.out.println("false");
		else
			System.out.println("True");
	}
}
