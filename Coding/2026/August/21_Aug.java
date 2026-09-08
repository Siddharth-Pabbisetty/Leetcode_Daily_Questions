// Daily Problem 21st August

import java.util.Arrays;

class Solution {
    boolean solve(long mid, int[] arr, int n, int k)
    {
        long cnt=0;
        for(int i=1;i<=n;i++)
        {
            int q=(1<<i)-1;
            while(q<1<<n)
            {
                long x=1;
                for(int j=0;j<n;j++)
                {
                    if(((q>>j)&1)!=0)
                    {
                        x=(x/gcd(x,arr[j]))*arr[j];
                    }
                }
                cnt+=(mid/x)*(((i&1)<<1)-1);
                int c=q&-q;
                int r=q+c;
                q=(((r^q)>>2)/c)|r;
            }
        }
        return cnt>=k;
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int[] arr=new int[coins.length];
        int n=0;
        for(int i:coins)
        {
            boolean b=true;
            for(int j=0;j<n;j++)
            {
                if(i%arr[j]==0)
                {
                    b=false;
                    break;
                }
            }
            if(b)
            {
                arr[n++]=i;
            }
        }
        long l=k;
        long r=(long)arr[0]*k;
        while(l<r)
        {
            long mid=l+(r-l)/2;
            if(solve(mid,arr,n,k))
            {
                r = mid;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
    long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}