package stacks;

public class MaxAreaRectangle {
	static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;

		int left[] = new int[heights.length];
		int right[] = new int[heights.length];
		right[heights.length - 1] = heights.length;
		left[0] = -1;

		for (int i = 1; i < heights.length; i++) {
			int temp = i - 1;
			while (temp >= 0 && heights[temp] >= heights[i])
				temp = left[temp];

			left[i] = temp;
		}
		for (int i = heights.length - 2; i >= 0; i--) {
			int temp = i + 1;
			while (temp < heights.length && heights[temp] >= heights[i])
				temp = right[temp];

			right[i] = temp;
		}

		int max = 0;
		for (int i = 0; i < heights.length; i++)
			max = Math.max(max, heights[i] * (right[i] - left[i] - 1));

		return max;
	}

	static int maxRectangle(int arr[][]) {
		int row = arr.length, col = arr[0].length;
		int result = largestRectangleArea(arr[0]);

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = arr[i][j] == 1 ? arr[i][j] + arr[i - 1][j] : 0;
			}
			result = Math.max(result, largestRectangleArea(arr[i]));
		}
		return result;
	}

	public static void main(String[] args) {
		int A[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, };
		System.out.println(maxRectangle(A));
	}
}
