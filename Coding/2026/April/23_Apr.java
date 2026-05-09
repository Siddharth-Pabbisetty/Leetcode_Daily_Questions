// Daily Problem 23rd April

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            mp.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        long[] res = new long[n];
        for(List<Integer> v:mp.values())
        {
            if(v.size()>1)
            {
                int c=v.size();
                int i=v.get(0);
                long sum=0;
                for(int x:v)
                {
                    sum+=x;
                }
                res[i]=sum-(long)c*i;
                int x=0,y=c-2;
                for(int k=1;k<c;k++)
                {
                    int index=v.get(k);
                    res[index]=res[i]+(long)(x-y)*(index-i);
                    x++;
                    y--;
                    i=index;
                }
            }
        }
        return res;
    }
}