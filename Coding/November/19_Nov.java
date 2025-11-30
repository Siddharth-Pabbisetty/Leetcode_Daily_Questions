// Daily Problem 19th November

class Solution {
    public int findFinalValue(int[] nums, int original) {
        int flag=1;
        while(flag!=0)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==original)
                {
                    original*=2;
                    flag=1;
                    break;
                }
                else
                {
                    flag=0;
                }
            }
        }
        return original;
    }
}