//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
           int prefix =1;
        for(int i=0;i < nums.length;i++) {
             res[i] = prefix;
            prefix = prefix * nums[i];
        }
        int postfix = 1;
         for(int i=nums.length-1;i >=0;i--) {
             res[i] = res[i] * postfix;
            postfix =  postfix * nums[i];
        }
        return res;
    }
}

//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]

