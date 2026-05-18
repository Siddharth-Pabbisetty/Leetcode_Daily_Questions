// Daily Problem 1st May

class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0,num=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            num+=i*nums[i];
        }
        int maxi=num;
        for(int i=1;i<n;i++)
        {
            num+=sum-n*nums[n-i];
            maxi=Math.max(maxi,num);
        }
        return maxi;
    }
}