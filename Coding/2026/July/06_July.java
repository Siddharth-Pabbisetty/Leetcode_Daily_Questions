// Daily Problem 6th July

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int cnt=0;
        int maxi=0;
        for (int[] i:intervals)
        {
            if(i[1]>maxi)
            {
                cnt++;
                maxi=i[1];
            }
        }
        return cnt;
    }
}