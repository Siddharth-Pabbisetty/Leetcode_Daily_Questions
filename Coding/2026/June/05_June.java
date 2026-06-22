// Daily Problem 5th June

class Solution {
    static int[] arr = new int[570];

    static
    {
        int j=0;
        for(int i=0;i<1000;i++)
        {
            int r=i%10;
            int m=(i/10)%10;
            int l=(i/100)%10;
            if((m>Math.max(l,r)) | (m<Math.min(l,r)))
            {
                arr[j++]=i;
            }
        }
    }

    public long totalWaviness(long num1, long num2)
    {
        return waveCount(num2) - waveCount(num1-1);
    }

    private long waveCount(long num)
    {
        if(num<100)
        {
            return 0;
        }
        long res=0;
        for(int i:arr)
        {
            res += countWays(num, i);
        }
        return res;
    }
    private long countWays(long num, int pattern)
    {
        long type=pattern<100?1:0;
        long cnt=0,mult=1;
        for(int i=0;mult*100<=num;i++)
        {
            long pre=num/(mult*1000);
            long curr=(num/mult)%1000;
            long suf=num%mult;
            long ways=0;
            if(curr>pattern)
            {
                ways=pre-type+1;
            }
            else if(curr==pattern)
            {
                ways=Math.max(0L,pre-type);
                cnt+=suf+1;
            }
            else
            {
                ways=Math.max(0L,pre-type);
            }
            cnt+=ways*mult;
            mult*=10;
        }
        return cnt;
    }
}