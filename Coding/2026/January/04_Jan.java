// Daily Problem 4th January

class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int i:nums){
            int sum=0;
            int count=0;
            for(int j=1;j*j<=i;j++)
            {
                if(i%j==0)
                {
                    int div1=j;
                    int div2=i/j;
                    count++;
                    sum+=div1;
                    if(div1!=div2)
                    {
                        count++;
                        sum+=div2;
                    }
                }
                if(count>4)
                    ans+=0;
            }
            ans+=(count==4?sum:0);
        }
        return ans;
    }
}