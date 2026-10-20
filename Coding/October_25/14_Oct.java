//Daily problem of 14th october

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int l=nums.size();
        int curr=1,prev=0,maxi=0;
        for(int i=1;i<l;i++)
        {
            if (nums.get(i) > nums.get(i - 1))
                curr=curr+1;
            else
            {
                prev=curr;
                curr=1;
            }
            maxi=Math.max(maxi,Math.max(curr>>1,Math.min(prev,curr)));
            if (maxi>=k)
                return true;
        }
        return false;
    }
}