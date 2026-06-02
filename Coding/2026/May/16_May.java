// Daily Problem 16th May

class Solution {
    public int findMin(int[] nums) {
        int n=nums.length-1;
        int last=nums[n];
        int l=0,r=n;
        while(l<n && nums[l]==last)
        {
            l++;
        }
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if (nums[mid]>last)
            {
                l=mid+1;
            }
            else
            {
                r=mid;
            }
        }
        return nums[l];
    }
}