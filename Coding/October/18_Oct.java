//Daily problem of 18th october

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0,prev=(int)-1e9;

        for(int i:nums)
        {
            int maxi=Math.max(i-k, prev+1);
            if (maxi<= i+k)
            {
                prev=maxi;
                res=res+1;
            }
        }
        return res;
    }
}