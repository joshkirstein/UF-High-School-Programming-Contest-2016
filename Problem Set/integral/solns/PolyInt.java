/*
 * Problem Name: Polygonal Integral
 * Problem Code: polygonalintegral
 * Problem Author: Joshua Kirstein
 * Solution Author: Cormac McCarthy
 *
 * Solution: If we look at the area beneath two consecutive points, we can see
 * that they form a trapezoid. For example, imagine that the below trapezoid is
 * formed by the area underneath the line connecting two consecutive
 * points, (x1, y1) and (x2, y2)
 *
 * (x1, y1)
 *    |\
 *    | \
 *    |  \
 *    |   \
 * b1 |    \ (x2, y2)
 *    |    |
 *    |    | b2
 *    |    |
 *    ------
 *       h
 *
 * b1 and b2 represent the two bases of the trapezoid, and h represents the height.
 * Recall that the area of a trapezoid is 1/2 * h * (b1 + b2)
 *
 * So the area of the trapezoid between any two points is simply 1/2 * (x2 - x1) * (y1 + y2),
 * and we just need to iterate over all of the points to find the area between two
 * consecutive points, and add the areas to a running sum.
 */
import java.util.*;
import java.io.*;

public class PolyInt {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();

		// Iterate over all test cases
		while (cases-->0) {
			int points = in.nextInt();

			// The following arrays will keep track of the 
			// x and y values of the points that we read in
			// x[i] and y[i] represent the x and y values, 
			// respectively, of the ith point
			int[] x = new int[points];
			int[] y = new int[points];

			// Read in the x and y coordinates of each point from input
			for (int i = 0; i < points; i++) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
			}

			// The following variable will keep track of the running sum of
			// areas between two points
			double area = 0.0;

			// Iterate over every pair of consecutive points to find the area
			// of the corresponding trapezoid
			for (int i = 1; i < points; i++) {
				// Get the width of the trapezoid
				int width = x[i] - x[i-1];
				// Get the area of the trapzeoid and add it to our running sum
				area += 0.5 * width * (y[i] + y[i-1]);
			}

			// Print the area
			System.out.printf("%.2f\n", area);
		}
	}
}