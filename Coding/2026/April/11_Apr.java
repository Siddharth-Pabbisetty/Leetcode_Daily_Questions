// Daily Problem 11th April

import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            mp.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        int mini=Integer.MAX_VALUE;
        for(List<Integer> l:mp.values())
        {
            int m=l.size();
            if(m>=3)
            {
                for(int i=0;i<m-2;i++)
                {
                    int a=l.get(i);
                    int b=l.get(i+1);
                    int c=l.get(i+2);
                    int diff=2*(c-a);
                    mini=Math.min(mini,diff);
                }
            }
        }
        return mini==Integer.MAX_VALUE?-1:mini;
    }
}