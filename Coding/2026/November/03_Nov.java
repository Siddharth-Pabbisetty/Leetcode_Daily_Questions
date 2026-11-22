// Daily Problem 3rd November

class Solution {
    public int minMoves(int[] nums) {
        int maxi=0;
        int sum=0;
        for(int i:nums)
        {
            maxi=Math.max(maxi,i);
            sum+=i;
        }
        return nums.length*maxi-sum;
    }
}