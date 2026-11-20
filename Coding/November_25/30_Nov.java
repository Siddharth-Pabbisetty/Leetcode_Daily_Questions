// Daily Problem 30th November

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for(int i:nums)
            total+=i;

        long target=total%p;
        if(target==0)
            return 0;

        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0, -1);
        long len=0;
        int res=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            len=(len+nums[i])%p;
            int req=(int)((len-target+p)%p);
            if (mp.containsKey(req))
            {
                res=Math.min(res,i-mp.get(req));
            }
            mp.put((int)len, i);
        }
        return res==nums.length?-1:res;
    }
}