package hashing;

public class RemoveSpecificChars {
    static void removeChar(char[] str, char[] remove) {
	int index[] = new int[256];
	for (int i = 0; i < remove.length; i++) {
	    index[remove[i]] = 1;
	}
	for (int i = 0; i < str.length; i++) {
	    if (index[str[i]] == 1) {
		str[i] = ' ';
	    }
	}
	int count = 0;
	for (int i = 0; i < str.length; i++) {
	    if (Character.isWhitespace(str[i])) {
		count++;
	    } else {
		str[i - count] = str[i];
	    }
	}
	String ans = String.valueOf(str);
	ans = ans.substring(0, str.length - count);
	System.out.println(ans);
    }

    public static void main(String[] args) {
	String a = "Anurag";
	String b = "nur";
	removeChar(a.toCharArray(), b.toCharArray());
    }
}
