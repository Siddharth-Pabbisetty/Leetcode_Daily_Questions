// Daily Problem 22nd May

class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0,h=n-1;
        while(l<h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[n-1])
            {
                l=mid+1;
            }
            else
            {
                h=mid;
            }
        }
        int val=l;
        l=0;
        h=n-1;
        while(l<=h)
        {
            int mid=l+ (h-l)/2;
            int ans=(mid+val)%n;
            if(nums[ans]==target)
            {
                return ans;
            }
            if(nums[ans]<target)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }

        return -1;
    }
}