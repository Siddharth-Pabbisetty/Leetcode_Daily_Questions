// Daily Problem 3rd December

import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, HashMap<Integer, Integer>> mp1 = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> mp2 = new HashMap<>();

        int n = points.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dx=points[j][0] - points[i][0];
                int dy=points[j][1] - points[i][1];
                if (dx<0 || (dx==0 && dy<0))
                {
                    dx = -dx;
                    dy = -dy;
                }
                int hcf=gcd(dx,Math.abs(dy));
                int sx=dx/hcf;
                int sy=dy/hcf;
                int des=sx*points[i][1] - sy*points[i][0];
                int key1=(sx<<12) | (sy+2000);
                int key2=(dx<<12) | (dy+2000);
                mp1.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
                mp2.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
            }
        }

        return count(mp1)-count(mp2)/2;
    }

    private int count(HashMap<Integer, HashMap<Integer, Integer>> mp) {
        long ans = 0;
        for(HashMap<Integer, Integer> i:mp.values())
        {
            long sum=0;
            for(int j:i.values())
                sum+=j;

            for(int j:i.values())
            {
                sum-=j;
                ans+=(long)j*sum;
            }
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}