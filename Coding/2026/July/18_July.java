// Daily Problem 18th July

class Solution {
    public int findGCD(int[] nums) {
        int mini=1001,maxi=0;
        for(int i:nums)
        {
            if(i<mini)
            {
                mini=i;
            }
            if(i>maxi)
            {
                maxi=i;
            }
        }
        return gcd(mini,maxi);
    }

    private int gcd(int a, int b) {
        while(b!=0)
        {
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}