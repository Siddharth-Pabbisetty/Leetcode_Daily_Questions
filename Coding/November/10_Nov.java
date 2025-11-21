// Daily Problem 10th November

class Solution {
    public int minOperations(int[] nums) {
        int[] st = new int[nums.length + 1];
        int top=0;
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            while(st[top]>nums[i])
            {
                top--;
                ans++;
            }
            if(st[top] != nums[i])
                st[++top]=nums[i];
        }
        return ans+top;
    }
}