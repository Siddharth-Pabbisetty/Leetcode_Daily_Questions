//Daily problem of 28th october

class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length,cnt=0,l=0;
        int r=Arrays.stream(nums).sum();
        for(int i=0;i<n;i++)
        {
            l=l+nums[i];
            r=r-nums[i];
            if (nums[i]!=0)
                continue;
            if(l==r)
                cnt+=2;
            if(Math.abs(l-r)==1)
                cnt++;
        }
        return cnt;
    }
}
