// Daily Problem 17th April

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int res=100000,i=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int n:nums)
        {
            int j;
            if(mp.containsKey(n))
            {
                res=Math.min(res,i-mp.get(n));
            }
            for(j=0;n>0;n/=10)
                j=j*10+(n%10);
            mp.put(j,i++);
        }
        return res==100000?-1:res;
    }
}