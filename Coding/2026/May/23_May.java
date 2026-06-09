// Daily Problem 23rd May

class Solution {
    public boolean check(int[] nums) {
        boolean b=false;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i] > nums[(i+1)%n])
            {
                if(b)
                {
                    return false;
                }
                b=true;
            }
        }
        return true;
    }
}