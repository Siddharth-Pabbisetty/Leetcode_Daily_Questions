// Daily Problem 27th December

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] cnt = new int[n];
        long[] timer = new long[n];
        int c=0;
        while(c<meetings.length)
        {
            int[] curr = meetings[c];
            int start = curr[0];
            int end = curr[1];
            long dur = end - start;
            int room = -1;
            long earliest = Long.MAX_VALUE;
            int earliestRoom = -1;
            for(int i=0;i<n;i++)
            {
                if(timer[i]<earliest)
                {
                    earliest = timer[i];
                    earliestRoom = i;
                }
                if(timer[i]<=start)
                {
                    room = i;
                    break;
                }
            }
            if(room!=-1)
            {
                timer[room] = end;
                cnt[room]+=1;
            }
            else
            {
                timer[earliestRoom] += dur;
                cnt[earliestRoom]+=1;
            }
            c++;
        }
        int max=0,ans=0;
        for(int i=0;i<n;i++)
        {
            if(cnt[i]>max)
            {
                max=cnt[i];
                ans=i;
            }
        }
        return ans;
    }
}