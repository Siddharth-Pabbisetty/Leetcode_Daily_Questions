// Daily Problem 12th August

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> mp=new HashMap<>();
        int i=0,j=0;
        int res=0;
        while(j<nums.length)
        {
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while(mp.get(nums[j])>k)
            {
                mp.put(nums[i],mp.get(nums[i])-1);
                i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}