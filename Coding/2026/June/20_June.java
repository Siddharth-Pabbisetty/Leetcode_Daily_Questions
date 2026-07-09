// Daily Problem 20th June

class Solution {
    public int maxBuilding(int num, int[][] restrictions) {
        List<int[]> l=new ArrayList<>(Arrays.asList(restrictions));
        l.add(new int[]{1, 0});
        l.sort((a, b) -> Integer.compare(a[0], b[0]));
        int n=l.size();
        for(int i=1;i<n;i++)
        {
            l.get(i)[1]=yCap(l.get(i-1),l.get(i));
        }
        for(int i=n-2;i>=0;i--)
        {
            l.get(i)[1]=yCap(l.get(i+1),l.get(i));
        }
        int res=0;
        for(int i=1;i<n;i++)
        {
            res=Math.max(res,yPeak(l.get(i-1),l.get(i)));
        }
        return Math.max(res,l.get(n-1)[1]+num-l.get(n-1)[0]);
    }

    int yCap(int[] a, int[] b)
    {
        return Math.min(b[1],a[1]+Math.abs(b[0]-a[0]));
    }

    int yPeak(int[] a, int[] b)
    {
        return (a[1]+b[1]+b[0]-a[0])>>1;
    }
}