// Daily Problem 2nd June

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLand=3000;
        int minWater=minLand;
        int res=minWater;
        int n=landStartTime.length;
        int m=waterStartTime.length;
        for(int i=0;i<n;i++)
        {
            minLand=Math.min(minLand, landStartTime[i]+landDuration[i]);
        }

        for(int i=0;i<m;i++)
        {
            minWater=Math.min(minWater, waterStartTime[i]+waterDuration[i]);
            res=Math.min(res,Math.max(minLand,waterStartTime[i])+waterDuration[i]);
        }

        for(int i=0;i<n;i++)
        {
            res=Math.min(res,Math.max(minWater,landStartTime[i])+landDuration[i]);
        }

        return res;
    }
}