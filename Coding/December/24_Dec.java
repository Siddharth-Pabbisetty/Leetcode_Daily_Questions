// Daily Problem 24th December

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int i:apple)
        {
            sum+=i;
        }
        int[] arr=new int[51];
        int l=0,h=51;
        for(int i:capacity)
        {
            arr[i]++;
            l=Math.max(l,i);
            h=Math.min(h,i);
        }
        int ans=0;
        for(int i=l;i>=h && sum>0;i--)
        {
            while(arr[i]-- > 0 && sum>0)
            {
                sum-=i;
                ans++;
            }
        }
        return ans;
    }
}
