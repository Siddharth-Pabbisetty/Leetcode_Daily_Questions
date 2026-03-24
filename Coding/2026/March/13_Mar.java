// Daily Problem 13th March

class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long low=1,high=Long.MAX_VALUE;
        while(low<high)
        {
            long mid=low+(high-low)/2;
            long sum=0;
            for(int i=0;i<times.length && sum<height; i++)
            {
                sum+=(long)(Math.sqrt((double) mid/times[i]*2+0.25) - 0.5);
            }
            if(sum>=height)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}