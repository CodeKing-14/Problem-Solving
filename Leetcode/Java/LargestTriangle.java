// Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
// Example 1:

// Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
// Output: 2.00000
// Explanation: The five points are shown in the above figure. The red triangle is the largest.
// Example 2:

// Input: points = [[1,0],[0,0],[0,1]]
// Output: 0.50000

import java.util.ArrayList;
import java.util.List;

public class LargestTriangle {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
        System.out.println(obj.largestTriangleArea(points));
    }
}

class Solution {
    public double largestTriangleArea(int[][] points) {
        List<Integer> convexHull = new ArrayList<>();

        int n = points.length;
        int sweep = 0;

        for (int i = 0; i < n; i++) {
            if (points[sweep][0] < points[i][0]) {
                sweep = i;
            }
        }

        int startSweep = sweep;

        while (true) {
            int nextSweep = (sweep + 1) % n;
            for (int i = 0; i < n; i++) {
                double orientation = findArea(points[sweep][0], points[sweep][1],
                        points[nextSweep][0], points[nextSweep][1],
                        points[i][0], points[i][1]);
                if (orientation > 0) {
                    nextSweep = i;
                }
            }

            convexHull.add(nextSweep);
            sweep = nextSweep;
            if (nextSweep == startSweep)
                break;
        }

        int convexLen = convexHull.size();
        double maxArea = 0.;

        for (int i = 0; i < convexLen; i++) {
            int[] first = points[convexHull.get(i)];
            for (int j = i + 1; j < convexLen; j++) {
                int[] second = points[convexHull.get(j)];
                for (int k = j + 1; k < convexLen; k++) {
                    int[] third = points[convexHull.get(k)];
                    double area = Math.abs(findArea(first[0], first[1],
                            second[0], second[1],
                            third[0], third[1]));
                    if (area > maxArea)
                        maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private double findArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }
}