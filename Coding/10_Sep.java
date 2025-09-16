//Daily Problem 10th September

import java.util.*;

class Solution {
    public int minimumTeachings(int totalLanguages, int[][] userLanguages, int[][] friendships) {
        Set<Integer> users = new HashSet<>();

        for (int[] i : friendships) {
            int u1 = i[0] - 1;
            int u2 = i[1] - 1;
            boolean comm=false;

            for (int j : userLanguages[u1])
            {
                for (int k : userLanguages[u2])
                {
                    if (j==k)
                    {
                        comm=true;
                        break;
                    }
                }
                if (comm)
                    break;
            }

            if (!comm)
            {
                users.add(u1);
                users.add(u2);
            }
        }

        int ans = userLanguages.length + 1;

        for (int i=1; i<=totalLanguages;i++)
        {
            int cnt=0;
            for(int j:users)
            {
                boolean b = false;
                for (int k:userLanguages[j])
                {
                    if (k==i) {
                        b=true;
                        break;
                    }
                }
                if (!b)
                    cnt++;
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }
}