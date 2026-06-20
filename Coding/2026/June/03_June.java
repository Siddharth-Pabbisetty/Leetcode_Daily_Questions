// Daily Problem 3rd June

class Solution {
    static int MAX = 300005;

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int l=MAX,w=MAX,minLand=MAX,minWater=MAX;
        int n=landStartTime.length, m=waterStartTime.length;
        for(int i=0;i<n;i++) {
            l=Math.min(l,landStartTime[i]+landDuration[i]);
        }
        for(int i=0;i<m;i++)
        {
            w=Math.min(w,waterStartTime[i]+waterDuration[i]);
            minLand=Math.min(minLand,Math.max(waterStartTime[i],l)+waterDuration[i]);
        }
        for(int i=0;i<n;i++)
        {
            minWater=Math.min(minWater,Math.max(landStartTime[i],w)+landDuration[i]);
        }
        return Math.min(minWater,minLand);
    }
}