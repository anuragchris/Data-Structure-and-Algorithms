package recursion;

import java.util.ArrayList;
import java.util.List;

public class StringProblems {
	static void powerSet(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String out1 = output;
		String out2 = output;
		out2 += input.charAt(0);
		input = input.substring(1);
		powerSet(input, out1);
		powerSet(input, out2);
		return;
	}

	static void printPowerSet(String input) {
		String output = "";
		powerSet(input, output);
		return;
	}

	static List<List<Integer>> distinctSubsets(int[] arr) {
		// Link For Problem : https://leetcode.com/problems/subsets/
		List<Integer> current = new ArrayList<Integer>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		printDistinctSubsets(arr, 0, current, ans);
		return ans;
	}

	static void printDistinctSubsets(int[] arr, int i, List<Integer> current, List<List<Integer>> ans) {
		if (i == arr.length) {
			ans.add(new ArrayList<Integer>(current));
			return;
		}
		current.add(arr[i]);
		printDistinctSubsets(arr, i + 1, current, ans);
		current.remove(current.size() - 1);
		printDistinctSubsets(arr, i + 1, current, ans);
	}

	static void permutationWithSpaces(String input) {
		String output = "";
		output += input.charAt(0);
		input = input.substring(1, input.length());
		printPermutations(input, output);
		return;
	}

	static void printPermutations(String input, String output) {
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		String out1 = output;
		String out2 = output;
		out1 += "_";
		out1 += input.charAt(0);
		out2 += input.charAt(0);
		input = input.substring(1, input.length());
		printPermutations(input, out1);
		printPermutations(input, out2);
		return;
	}

	static List<String> letterCasePermutation(String s) {
		// Link For Problem : https://leetcode.com/problems/letter-case-permutation/
		String ip = s;
		String op = "";
		List<String> ls = new ArrayList<String>();
		solveLetterCasePermutation(ip, op, ls);
		return ls;
	}

	static void solveLetterCasePermutation(String ip, String op, List<String> ls) {
		if (ip.length() == 0) {
			ls.add(op);
			return;
		}
		if (Character.isAlphabetic(ip.charAt(0))) {
			String op1 = op;
			String op2 = op;
			op1 += Character.toLowerCase(ip.charAt(0));
			op2 += Character.toUpperCase(ip.charAt(0));
			ip = ip.substring(1, ip.length());
			solveLetterCasePermutation(ip, op1, ls);
			solveLetterCasePermutation(ip, op2, ls);
		} else {
			String op1 = op;
			op1 += ip.charAt(0);
			ip = ip.substring(1, ip.length());
			solveLetterCasePermutation(ip, op1, ls);
		}
		return;
	}

	static List<String> generateParenthesis(int n) {
		List<String> ls = new ArrayList<String>();
		int open = n;
		int close = n;
		String op = "";
		solveGenerateParenthesis(open, close, op, ls);
		return ls;
	}

	static void solveGenerateParenthesis(int open, int close, String op, List<String> ls) {
		if (open == 0 && close == 0) {
			ls.add(op);
			return;
		}
		if (open > 0) {
			String op1 = op;
			op1 += "(";
			solveGenerateParenthesis(open - 1, close, op1, ls);
		}
		if (close > open) {
			String op2 = op;
			op2 += ")";
			solveGenerateParenthesis(open, close - 1, op2, ls);
		}
		return;
	}

	static void nBitBinaryNumbers(int n) {
		// Link For Problem :
		// https://www.geeksforgeeks.org/print-n-bit-binary-numbers-1s-0s-prefixes/
		String op = "";
		int one = 0;
		int zero = 0;
		printNBitBinaryNumbers(one, zero, n, op);
	}

	static void printNBitBinaryNumbers(int one, int zero, int n, String op) {
		if (n == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		op1 += "1";
		printNBitBinaryNumbers(one + 1, zero, n - 1, op1);
		if (one > zero) {
			String op2 = op;
			op2 += "0";
			printNBitBinaryNumbers(one, zero + 1, n - 1, op2);
		}
		return;
	}

	static void josePhus(int n, int k) {
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			ls.add(i);
		}
		k = k - 1;
		int index = 0;
		int ans = -1;
		solveJosePhus(ls, k, index, ans);
	}

	static void solveJosePhus(List<Integer> ls, int k, int index, int ans) {
		if (ls.size() == 1) {
			ans = ls.get(0);
			System.out.println(ans);
			return;
		}
		index = (index + k) % (ls.size());
		ls.remove(index);
		solveJosePhus(ls, k, index, ans);
	}

	public static void main(String[] args) {
//		String input = "abc";
		// printPowerSet(input);
//		int arr[] = { 1, 2, 3 };
//		System.out.println(distinctSubsets(arr));
//		String input = "ABCD";
//		permutationWithSpaces(input);
//		String input = "a1b2";
//		System.out.println(letterCasePermutation(input));
//		System.out.println(generateParenthesis(3));
//		nBitBinaryNumbers(4);
		josePhus(14, 2);
	}
}
