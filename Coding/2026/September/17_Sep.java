// Daily Problem 17th September

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int res=n+1;
        int sum=0;
        int i=0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,n);
        for(int j=0;j<n;j++)
        {
            sum+=arr[j];
            while(sum>target)
            {
                sum-=arr[i++];
            }
            dp[j+1]=dp[j];
            if(sum==target)
            {
                res=Math.min(res,j-i+1+dp[i]);
                dp[j+1]=Math.min(dp[j],j-i+1);
            }
        }
        return res==n+1?-1:res;
    }
}