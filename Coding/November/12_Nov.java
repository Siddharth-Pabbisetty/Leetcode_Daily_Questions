// Daily Problem 12th November

class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int num1=0;
        int g=0;
        for(int i:nums)
        {
            if(i==1)
            {
                num1++;
            }
            g=gcd(g,i);
        }
        if(num1>0)
        {
            return n-num1;
        }
        if(g>1)
        {
            return -1;
        }

        int mini=n;
        for(int i=0;i<n;i++)
        {
            int curr=0;
            for(int j=i;j<n;j++)
            {
                curr=gcd(curr,nums[j]);
                if(curr==1)
                {
                    mini=Math.min(mini,j-i+1);
                    break;
                }
            }
        }
        return mini+n-2;
    }

    private int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}