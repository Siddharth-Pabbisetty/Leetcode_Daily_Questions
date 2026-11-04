// Daily Problem 16th October

class Solution {
    public int sumCounts(int[] nums) {
        long MOD=1000000007;
        int n = nums.length;
        long[] cnt=new long[n+1];
        long[] total=new long[n+1];
        Map<Integer, Integer> mp=new HashMap<>();
        long ans=0;
        for(int i=0;i<n;i++)
        {
            int p=mp.getOrDefault(nums[i],-1);
            long c=0,s=0;
            for(int j=n-p-1;j>0;j-=j&-j)
            {
                c+=cnt[j];
                s+=total[j];
            }
            long gain=(long)(i-p)*(i-p)-2*(s-p*c);
            ans=(ans+(n-i)*gain)%MOD;
            for(int j=n-p;j<=n;j+=j&-j)
            {
                cnt[j]++;
                total[j]+=p;
            }
            mp.put(nums[i],i);
        }
        return (int) ans;
    }
}