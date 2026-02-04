// Daily Problem 23rd January

class Solution {

    private static class Paor {
        long sum;
        int idx;
        Paor(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if(n<=1)
            return 0;
        long[] arr=new long[n];
        for(int i=0;i<n;++i)
            arr[i] = nums[i];
        boolean[] r=new boolean[n];

        PriorityQueue<Paor> pq = new PriorityQueue<>(new Comparator<Paor>() {
            public int compare(Paor a, Paor b)
            {
                if (a.sum < b.sum)
                    return -1;
                if (a.sum > b.sum)
                    return 1;
                return Integer.compare(a.idx, b.idx);
            }
        });

        int cnt=0;
        for(int i=1;i<n;++i)
        {
            pq.add(new Paor(arr[i-1] + arr[i], i-1));
            if(arr[i] >= arr[i-1])
                cnt++;
        }
        if (cnt == n-1)
            return 0;
        int rem = n;
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i=0;i<n;++i)
        {
            prev[i]=i-1;
            next[i]=i+1;
        }

        while(rem>1)
        {
            Paor top=pq.poll();
            if(top==null)
                break;
            long sum=top.sum;
            int left=top.idx;
            int right=next[left];
            if(right >= n || r[left] || r[right] || arr[left] + arr[right] != sum)
                continue;

            int pre = prev[left];
            int nxt = next[right];

            if (arr[left] <= arr[right])
            {
                cnt--;
            }
            if (pre != -1 && arr[pre] <= arr[left])
            {
                cnt--;
            }
            if (nxt != n && arr[right] <= arr[nxt])
            {
                cnt--;
            }

            arr[left] += arr[right];
            r[right] = true;
            rem--;

            if(pre!=-1)
            {
                pq.add(new Paor(arr[pre] + arr[left], pre));
                if(arr[pre] <= arr[left])
                    cnt++;
            }
            else
            {
                prev[left]=-1;
            }

            if (nxt != n)
            {
                prev[nxt] = left;
                next[left] = nxt;
                pq.add(new Paor(arr[left] + arr[nxt], left));
                if(arr[left] <= arr[nxt])
                {
                    cnt++;
                }
            }
            else
            {
                next[left] = n;
            }
            if (cnt == rem-1)
            {
                return n - rem;
            }
        }
        return n;
    }
}
