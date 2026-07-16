// Daily Problem 27th June

class Solution {
    static int MAX_BASE = 31622;

    public int maximumLength(int[] nums) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:nums)
        {
            mp.merge(i, 1,Integer::sum);
        }

        int one=mp.getOrDefault(1,0);
        int res=(one-1)|1;
        mp.remove(1);

        for(int i:mp.keySet())
        {
            int sq=(int) Math.sqrt(i);
            if(sq*sq==i && mp.getOrDefault(sq,0)>1)
            {
                continue;
            }
            int n=0,x=i;
            while(x<31623 && mp.containsKey(x) && mp.get(x)>1)
            {
                n+=2;
                x*=x;
            }
            res=Math.max(res,n+(mp.containsKey(x)?1:-1));
        }
        return res;
    }
}