// Daily Problem 18th October

class Solution {
    static long MOD=1000000007L;

    public int numOfWays(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        Arrays.fill(arr,-1);
        for(int i=0;i<n;i++)
        {
            arr[nums[i]]=i;
        }
        long fact=1;
        long sizes=1;
        for(int i=2;i<=n;i++)
        {
            fact=fact*i%MOD;
        }
        int[] stack=new int[n+2];
        int top=0;
        for(int i=1;i<=n+1;i++)
        {
            while(arr[stack[top]]>arr[i])
            {
                top--;
                sizes=sizes*(i-stack[top]-1)%MOD;
            }
            stack[++top]=i;
        }
        return (int) ((fact * solve(sizes,MOD-2)-1+MOD)%MOD);
    }

    private long solve(long a, long b)
    {
        long res=1;
        for(a%=MOD;b>0;b>>=1,a=a*a%MOD)
        {
            if((b&1)==1)
            {
                res = res * a % MOD;
            }
        }
        return res;
    }
}