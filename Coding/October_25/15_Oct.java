//Daily problem of 15th october

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int l=nums.size();
        int maxi=1, prev=0, ans=0;
        for (int i=1;i<l;i++)
        {
            if (nums.get(i) > nums.get(i-1))
            {
                maxi++;
            }
            else
            {
                prev=maxi;
                maxi=1;
            }
            int val=maxi>>1;
            int mini=prev<maxi?prev:maxi;
            int sub =val>mini?val:mini;
            if (sub > ans)
                ans = sub;
        }
        return ans;
    }
}