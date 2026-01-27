// Daily Problem 15th January

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int ans=Math.min(solve(hBars),solve(vBars));
        return ans*ans;
    }

    private int solve(int[] arr)
    {
        int val=1,area=1;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1] == 1)
                area++;
            else
                area=1;
            val=Math.max(val,area);
        }
        return val+1;
    }
}
