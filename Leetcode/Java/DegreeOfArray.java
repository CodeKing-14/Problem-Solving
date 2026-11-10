// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

// Example 1:

// Input: nums = [1,2,2,3,1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
// Example 2:

// Input: nums = [1,2,2,3,1,4,2]
// Output: 6
// Explanation: 
// The degree is 3 because the element 2 is repeated 3 times.
// So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.

import java.util.HashMap;

class DegreeOfArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = { 1, 2, 2, 3, 1 };
        System.out.println(solution.findShortestSubArray(nums1));
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            first.putIfAbsent(num, i);
            last.put(num, i);
        }

        int degree = 0;

        for (int count : freq.values()) {
            degree = Math.max(degree, count);
        }

        int minLength = nums.length;

        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                minLength = Math.min(
                    minLength,
                    last.get(num) - first.get(num) + 1
                );
            }
        }

        return minLength;
    }
}