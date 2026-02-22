// Daily Problem 10th February

class Solution {
    public int longestBalanced(int[] nums) {
        int[] arr= new int[100001];
        int cnt=1;
        int n=nums.length;
        int res=0;
        for(int i=0;i<n && n-i>res;i++)
        {
            int[] a=new int[2];
            int flag=(cnt<<16)|(i+1);
            for(int j=i;j<n;j++)
            {
                int val=nums[j];
                if(arr[val]!=flag)
                {
                    arr[val]=flag;
                    a[val&1]++;
                }
                if(a[0]==a[1])
                {
                    res=Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}