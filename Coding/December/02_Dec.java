// Daily Problem 2nd December

import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD = 1000000007L;
        HashMap<Integer, Long> mp = new HashMap<>();
        for(int[] i:points)
        {
            mp.put(i[1], mp.getOrDefault(i[1],0L)+1);
        }
        ArrayList<Long> al=new ArrayList<>();
        for(long i:mp.values())
        {
            if(i>=2)
                al.add((i*(i-1)/2)%MOD);
        }
        long sum=0,ans=0;
        for(long i:al)
        {
            ans=(ans+i*sum)%MOD;
            sum=(sum+i)%MOD;
        }
        return (int)ans;
    }
}