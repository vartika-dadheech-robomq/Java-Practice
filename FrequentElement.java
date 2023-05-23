 //Given an integer array nums and an integer k, return the k most frequent elements.
 //You may return the answer in any order.

 class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> top = new HashMap<>();
        for(int i =0; i< nums.length; i++) {
            top.put(nums[i], top.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
            b.getValue() - a.getValue()
        );
        for(Map.Entry<Integer, Integer> freq: top.entrySet()) {
            pq.add(freq);
        }
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = pq.poll().getKey();
        }
        return arr;
    }
   
}

//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]