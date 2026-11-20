// Daily Problem 20th November

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int res=0;
        int a=-1,b=-1;
        for (int[] i:intervals)
        {
            int l=i[0],r=i[1];
            if(l>b)
            {
                a=r-1;
                res=res+2
                b=r;
            }
            else if(l>a)
            {
                a=b;
                b=r;
                res=res+1;
            }
        }
        return ans;
    }
}