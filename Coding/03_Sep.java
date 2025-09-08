//Daily Problem 3rd September

import java.util.*;
class Solution {
    public int numberOfPairs(int[][] P) {
        Arrays.parallelSort(P, (a, b) ->
        {
            return a[0]==b[0]?(a[1]-b[1]):(b[0]-a[0]);
        });
        int n=P.length;
        int cnt=0;
        for(int i=0; i<n-1; i++)
        {
            int y=Integer.MAX_VALUE, y1=P[i][1];
            for(int j = i+1; j<n; j++)
            {
                int y2=P[j][1];
                if (y2>=y1 && y>y2)
                {
                    cnt++;
                    y=y2;
                    if (y1==y2)
                        break;
                }
            }
        }
        return cnt;
    }
}
