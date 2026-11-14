"""
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true

Example 2:

Input: nums = [1, 2, 3, 4]

Output: false
"""

# brute force for more time

from typing import List

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        for i in range(len(nums) - 1):
            for j in range(i+1, len(nums)):
                if(nums[i] == nums[j]):
                    return True
                j = j + 1

        return False

obj = Solution()
nums = [1, 2, 3, 3]

print(obj.hasDuplicate(nums))

'''
brute force for less time

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        return len(nums) != len(set(nums))

obj = Solution()
nums = [1, 2, 3, 3]

print(obj.hasDuplicate(nums))
'''