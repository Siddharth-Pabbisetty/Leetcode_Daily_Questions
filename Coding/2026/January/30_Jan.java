// Daily Problem 30th January

class Solution {

    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost) {
        long MOD=Long.MAX_VALUE;
        Map<String, Integer> mp=new HashMap<>();
        Set<Integer> s = new HashSet<>();

        int sz = 0;
        int m = original.length;
        int n = source.length();

        long[][] dist = new long[201][201];
        for (long[] i:dist)
            Arrays.fill(i,MOD);

        for(int i=0;i<m;i++)
        {
            if(!mp.containsKey(original[i]))
            {
                mp.put(original[i],sz++);
                s.add(original[i].length());
            }
            if (!mp.containsKey(changed[i]))
            {
                mp.put(changed[i], sz++);
            }
            int u=mp.get(original[i]);
            int v=mp.get(changed[i]);
            dist[u][v]=Math.min(dist[u][v], cost[i]);
        }

        for(int i=0;i<sz;i++) {
            dist[i][i] = 0;
        }
        for(int k=0;k<sz;k++)
        {
            for(int i=0;i<sz;i++)
            {
                if(dist[i][k]!=MOD)
                {
                    for(int j=0;j<sz;j++)
                    {
                        if(dist[k][j]!=MOD)
                        {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                        }
                    }
                }
            }
        }
        long[] dp = new long[n+1];
        Arrays.fill(dp,MOD);
        dp[0]=0;

        for(int i=0;i<n;i++)
        {
            if(dp[i]==MOD)
            {
                continue;
            }

            if(source.charAt(i) == target.charAt(i))
            {
                dp[i+1]=Math.min(dp[i+1],dp[i]);
            }

            for (int j:s)
            {
                if(i+j > n)
                {
                    continue;
                }
                String s1 = source.substring(i,i+j);
                String t = target.substring(i,i+j);

                if (mp.containsKey(s1) && mp.containsKey(t))
                {
                    long d = dist[mp.get(s1)][mp.get(t)];
                    if(d!=MOD)
                    {
                        dp[i+j] = Math.min(dp[i+j],dp[i]+d);
                    }
                }
            }
        }

        return dp[n]==MOD?-1:dp[n];
    }
}