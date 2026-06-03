// Daily Problem 17th May

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] b=new boolean[n];
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty())
        {
            int val=q.poll();
            if(val<0 || val>=n || b[val])
            {
                continue;
            }
            if(arr[val]==0)
            {
                return true;
            }
            b[val]=true;
            q.offer(val+arr[val]);
            q.offer(val-arr[val]);
        }
        return false;
    }
}