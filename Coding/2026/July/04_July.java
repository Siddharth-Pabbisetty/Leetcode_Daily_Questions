// Daily Problem 4th July

class Solution {
    int solve(int[] arr, int i) {
        if(arr[i]==i)
        {
            return i;
        }
        return arr[i]=solve(arr,arr[i]);
    }

    public int minScore(int n, int[][] roads) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=i;
        }
        for(int[] i:roads)
        {
            arr[solve(arr,i[0])]=solve(arr,i[1]);
        }

        int res=10001;
        for(int[] i:roads)
        {
            if(solve(arr,i[0]) == solve(arr,1))
            {
                res=Math.min(res,i[2]);
            }
        }
        return res;
    }
}