
/*@author : Samuel Musee
 * 
 * McGill ID; 260708510
 * 
 */

import java.util.Random;

public class SortAndFind {

	public static void main(String[] args) {

		// generateRandomMatrix(3, 4);
		// displayMatrix(generateRandomMatrix(3, 4));
		// displayMatrix(generateRandomMatrix(6, 8));
		int[] x = { 28, 3, 8, 42, 21, 44, 11, 22 };
		// sortOneRow(x);

		int[][] y = { { 32, 0, 26 }, { 39, 45, 7 }, { 34, 37, 35 }, { 3, 39, 26 }, { 22, 15, 37 } };

		int[][] z = { { 0, 22, 32 }, { 3, 26, 37 }, { 7, 26, 37 }, { 15, 35, 39 }, { 34, 39, 45 } };

		// displayMatrix(z);
		// sortMatrix(z);
		System.out.println();
		// System.out.println(Arrays.toString(findElement(z, 15)));

		findElement(z, 26);
		// displayMatrix(z);

		// displayMatrix(sortOneColumn(y, 1));

		// System.out.println();

		/*
		 * displayMatrix(y); sortMatrix(y); System.out.println(); displayMatrix(y);
		 */
	}

	public static int[][] generateRandomMatrix(int m, int n) {
		int[][] matrix = new int[m][n];

		// generating random values based on seed

		Random randomArr = new Random(123);

		// populating matrix

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = randomArr.nextInt(50);
			}
		}
		return matrix;

	}

	// display output
	public static void displayMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void sortOneRow(int[] arr1) { // method to sort 1-dimensional array

		int temp;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				if (arr1[i] > arr1[j]) {
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}
		}

		/*
		 * // displaying results of sorting
		 * 
		 * for (int i = 0; i < arr1.length; ++i) System.out.print(arr1[i] + " ");
		 */
	}

	public static void sortOneColumn(int[][] x, int colNo) { // method to sort 1-dimensional array

		/*
		 * // Sort each colum. for (int col = 0; col < x[0].length; col++) {
		 */

		// Pull the column out.
		int[] thisCol = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			thisCol[i] = x[i][colNo];
		}

		// Sort it.
		sortOneRow(thisCol);
		// Push it back in.
		for (int i = 0; i < x.length; i++) {
			x[i][colNo] = thisCol[i];
		}
		// return x;

	}

	public static void sortMatrix(int[][] inputArr) {

		// sort rows first
		for (int i = 0; i < inputArr.length; i++) {
			sortOneRow(inputArr[i]);

		}

		// sort columns
		for (int j = 0; j < inputArr[0].length; j++) {
			sortOneColumn(inputArr, j);

		}
	}

	public static int[] findElement(int[][] matrix, int n) {
		// int index = [matrix.length][matrix[0].length];

		int[] answerArray = new int[2];
		for (int row = matrix.length - 1; row > 1; row--) {
			for (int col = 0; col < matrix[0].length; col++) {

				if (matrix[row][col] == n) {
					// n = matrix[row][col];
					answerArray[0] = row;
					answerArray[1] = col;
					// return answerArray;

				}

				if (matrix[row][col] < n) {
					row--;

				}
				if (matrix[row][col] > n) {
					col = col++;

				} else if (matrix[row][col] != n) {
					answerArray[0] = -1;
					answerArray[1] = -1;
				}

			}
		}
		System.out.print("Index is " + answerArray[0] + ", " + answerArray[1]);
		return answerArray;

	}

}
