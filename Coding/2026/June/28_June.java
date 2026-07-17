// Daily Problem 28th June

class Solution {
    private static final int[] freq = new int[100005];
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        for(int i:arr)
        {
            freq[Math.min(i,n)]++;
        }
        int res=1;
        for(int i=2;i<=n;i++)
        {
            res=Math.min(res+freq[i],i);
        }
        for(int i=0;i<=n;i++)
        {
            freq[i]=0;
        }
        return res;
    }
}