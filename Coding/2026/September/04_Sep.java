// Daily Problem 4th September

class Solution {
    static int[] arr=new int[100];
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        arr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            arr[i]=Math.min(arr[i+1],nums[i]);
        }
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
            if(maxi<=k+arr[i]) {
                return i;
            }
        }
        return -1;
    }
}