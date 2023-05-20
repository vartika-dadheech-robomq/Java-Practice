//Given an array of integers nums and an integer target, 
//return indices of the two numbers such that they add up to target.

//You may assume that each input would have exactly one solution, 
//and you may not use the same element twice.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num = new HashMap<Integer, Integer>();
        int[] arr = new int[2];
        for(int i = 0; i<nums.length; i++) {
            if (num.containsKey(target-nums[i])) {
                arr[0] = num.get(target-nums[i]);
                arr[1] = i;
                return arr;
            }
            num.put(nums[i], i);
        }
        return arr;
    }
}

//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].