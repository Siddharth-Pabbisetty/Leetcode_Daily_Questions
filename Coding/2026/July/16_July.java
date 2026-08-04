// Daily Problem 16th July

class Solution {
    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int maxi=-1;
        for(int i=0;i<nums.length;i++)
        {
            maxi=Math.max(maxi,nums[i]);
            prefixGcd[i]=gcd(maxi,nums[i]);
        }
        Arrays.sort(prefixGcd);
        long sum=0;
        int i=0,j=nums.length-1;

        while(i<j)
        {
            sum+=gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }

    private int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}