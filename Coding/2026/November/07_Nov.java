// Daily Problem 7th November

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        for(int i=0;i<servers.length;i++)
        {
            pq.offer(new int[]{servers[i],i});
        }
        PriorityQueue<long[]> pq1=new PriorityQueue<>((a, b) ->
        {
            if(a[0]!=b[0])
            {
                return Long.compare(a[0],b[0]);
            }
            if(a[1]!=b[1])
            {
                return Long.compare(a[1],b[1]);
            }
            return Long.compare(a[2],b[2]);
        });
        int m=tasks.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++)
        {
            while(!pq1.isEmpty() && pq1.peek()[0]<=i)
            {
                long[] curr=pq1.poll();
                pq.offer(new int[]{(int)curr[1],(int)curr[2]});
            }
            if(!pq.isEmpty())
            {
                int[] curr=pq.poll();
                ans[i]=curr[1];
                pq1.offer(new long[]{i+(long)tasks[i],curr[0],curr[1]});
            }
            else
            {
                long[] curr=pq1.poll();
                ans[i]=(int)curr[2];
                pq1.offer(new long[]{curr[0]+tasks[i],curr[1],curr[2]});
            }
        }
        return ans;
    }
}