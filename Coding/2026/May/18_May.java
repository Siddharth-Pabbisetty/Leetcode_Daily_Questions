// Daily Problem 18th May
import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1)
        {
            return 0;
        }

        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.computeIfAbsent(arr[i], k->new ArrayList<>()).add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[] b=new boolean[n];
        b[0]=true;
        while(!q.isEmpty())
        {
            int[] a=q.poll();
            int node=a[0];
            int dist=a[1];
            if(node==n-1)
            {
                return dist;
            }
            if(node-1>=0 && !b[node-1])
            {
                b[node-1]=true;
                q.offer(new int[]{node-1,dist+1});
            }
            if(node+1<n && !b[node+1])
            {
                b[node+1]=true;
                q.offer(new int[]{node+1,dist+1});
            }
            for(int i:mp.get(arr[node]))
            {
                if(!b[i])
                {
                    b[i] = true;
                    q.offer(new int[]{i,dist+1});
                }
            }
            mp.get(arr[node]).clear();
        }
        return -1;
    }
}