// Daily Problem 6th February

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int j=0;
        int maxi=0;
        for(int i=0;i<nums.length;i++)
        {
            while((long)nums[i] > (long)nums[j]*k)
            {
                j++;
            }
            maxi=Math.max(maxi,i-j+1);
        }
        return nums.length-maxi;
    }
}