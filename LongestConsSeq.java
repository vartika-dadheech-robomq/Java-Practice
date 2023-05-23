/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            numbers.add(num);
        }
        int streak = 0;
        for (int ele : nums) {
            if (!numbers.contains(ele - 1)) {
                int curNum = ele;
                int curStreak = 1;
                numbers.remove(ele);
                while (numbers.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                    numbers.remove(curNum);
                }
                streak = Math.max(streak, curStreak);
            }
        }
        return streak;
    }
}