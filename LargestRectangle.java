/*
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
 * return the area of the largest rectangle in the histogram.
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int rigL = 0, lefL = -1;
        Stack<Integer> ind = new Stack<>();
        ind.push(-1);
        ind.push(0);
        int maxArea = heights[0] * 1;
        for (int i = 1; i <= heights.length; i++) {
            if (i == heights.length) {
                rigL = ind.peek() + 1;
                while (ind.peek() != -1) {
                    int topValue = ind.pop();
                    lefL = ind.peek();
                    int width = rigL - lefL - 1;
                    maxArea = Math.max(maxArea, width * heights[topValue]);
                }
            } else if (heights[i] < heights[ind.peek()]) {
                rigL = ind.peek() + 1;
                while (ind.peek() != -1 && heights[ind.peek()] > heights[i]) {
                    int topValue = ind.pop();
                    lefL = ind.peek();
                    int width = rigL - lefL - 1;
                    maxArea = Math.max(maxArea, width * heights[topValue]);
                }
                ind.push(i);
            } else {
                rigL = i + 1;
                ind.push(i);
            }
        }
        return maxArea;
    }
}
