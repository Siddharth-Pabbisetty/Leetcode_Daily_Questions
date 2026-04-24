// Daily Problem 10th April

class Solution {
    public int minimumDistance(int[] nums) {
        int len=nums.length;
        int[] arr=new int[len];
        int res=200;
        for(int i=0;i<len;i++)
        {
            int val=nums[i]-1;
            int pos=i+1,pack=arr[val];
            int old=pack&255,cur=pack>>8;
            arr[val]=cur|(pos<<8);
            if(old>0)
            {
                res=Math.min(res,(pos-old)<<1);
            }
        }
        return res==200?-1:res;
    }
}