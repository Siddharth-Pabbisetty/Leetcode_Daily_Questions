// Daily Problem 31st October

class Solution {
    public int uniquePaths(int[][] grid) {
        int MOD=1000000007;
        int[] arr=new int[grid[0].length];
        arr[0]=1;
        for(int[] a:grid)
        {
            int right=0;
            for(int j=0;j<a.length;j++)
            {
                if(a[j]==1)
                {
                    right=right+arr[j]-(arr[j]=right);
                }
                else
                {
                    right=arr[j]=(right+arr[j])%MOD;
                }
            }
        }
        return arr[arr.length-1];
    }
}