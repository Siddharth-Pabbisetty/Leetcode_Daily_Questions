// Daily Problem 3rd February

class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int peak=n-1,c=0;

        for(int i=0;i<n-1;i++)
        {
            if(peak==n-1 && nums[i] >= nums[i+1])
            {
                peak=i;
            }
            if(c==0 && nums[n-1-i] <= nums[n-2-i])
            {
                c=n-1-i;
            }
            if(peak<c)
            {
                return check(nums,peak,c);
            }
        }

        return false;
    }

    public boolean check(int[] A, int a, int b) {
        if(a==0 || b==A.length-1)
        {
            return false;
        }
        for(int i=a;i<b;i++)
        {
            if(A[i] <= A[i+1])
            {
                return false;
            }
        }

        return true;
    }
}
