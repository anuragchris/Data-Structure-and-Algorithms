package hashing;

public class LeftMostRepeatedCharacter {
    static int leftMost(String str) {
	for (int i = 0; i < str.length() - 1; i++) {
	    String s = str.substring(i + 1);
	    if (s.contains(Character.toString(str.charAt(i))))
		return i;
	}

	return -1;
    }

    static int usingSingleLoop(String s) {
	char[] str = s.toCharArray();
	int firstIndex[] = new int[256];
	for (int i = 0; i < firstIndex.length; i++) {
	    firstIndex[i] = -1;
	}
	int result = Integer.MAX_VALUE;
	for (int i = 0; i < str.length; i++) {
	    if (firstIndex[str[i]] == -1) {
		firstIndex[str[i]] = i;
	    } else {
		result = Math.min(result, firstIndex[str[i]]);
	    }
	}
	return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    public static void main(String args[]) {
	String str = "aeccbd";
//	System.out.print("Index of leftmost repeating character: ");
//	System.out.println(leftMost(str));
	System.out.println(usingSingleLoop(str) + " " + str.charAt(usingSingleLoop(str)));
    }
}
