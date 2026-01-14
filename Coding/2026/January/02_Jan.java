// Daily Problem 2nd January

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        Set<Integer> s = new HashSet<>();
        for(int i:nums)
        {
            if(!s.add(i))
                return i;
        }
        return nums[n-1];
    }
}