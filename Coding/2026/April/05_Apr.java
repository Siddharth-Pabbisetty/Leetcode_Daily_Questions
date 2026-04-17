// Daily Problem 5th April

import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> st = new HashSet<>();
        for (int[] i : obstacles)
        {
            st.add(i[0] + "," + i[1]);
        }
        int[][] directions={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x=0,y=0;
        int dir=0;
        int maxi=0;

        for(int i:commands)
        {
            if(i==-1)
            {
                dir=(dir+1)%4;
            }
            else if(i==-2)
            {
                dir=(dir+3)%4;
            }
            else
            {
                while(i-->0)
                {
                    int nx=x+directions[dir][0];
                    int ny=y+directions[dir][1];
                    if(st.contains(nx + "," + ny))
                    {
                        break;
                    }
                    x=nx;
                    y=ny;
                    maxi=Math.max(maxi,x*x+y*y);
                }
            }
        }
        return maxi;
    }
}