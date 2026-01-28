// Daily Problem 16th January

import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> l1=new ArrayList<>();
        for(int i:hFences)
        {
            l1.add(i);
        }
        l1.add(1);
        l1.add(m);

        List<Integer> l2 = new ArrayList<>();
        for(int i:vFences)
        {
            l2.add(i);
        }
        l2.add(1);
        l2.add(n);

        Set<Integer> s=new HashSet<>();
        long res=0;
        for(int i=0;i<l1.size();i++)
        {
            for(int j=i+1;j<l1.size();j++)
            {
                s.add(Math.abs(l1.get(j)-l1.get(i)));
            }
        }
        for(int i=0;i<l2.size();i++)
        {
            for(int j=i+1;j<l2.size();j++)
            {
                int val=Math.abs(l2.get(j)-l2.get(i));
                if(s.contains(val))
                {
                    res=Math.max(res,val);
                }
            }
        }
        if(res==0)
        {
            return -1;
        }
        long MOD=1000000007;
        return (int)((res*res)%MOD);
    }
}