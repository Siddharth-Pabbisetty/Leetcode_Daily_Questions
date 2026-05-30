// Daily Problem 13th May

class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] arr=new int[2*limit + 2];
        for(int i=0;i<n/2;i++)
        {
            int a=nums[i];
            int b=nums[n-i-1];
            if(a>b)
            {
                a=a+b-(b=a);
            }
            int sum=a+b;
            int l=a+1;
            int r=b+limit;

            arr[2]+=2;
            arr[2*limit + 1]-=2;

            arr[l]-=1;
            arr[r+1]+=1;

            arr[sum]-=1;
            arr[sum+1]+=1;
        }
        int res=Integer.MAX_VALUE;
        int curr=0;
        for(int i=2;i<=2*limit;i++)
        {
            curr+=arr[i];
            res=Math.min(res,curr);
        }
        return res;
    }
}