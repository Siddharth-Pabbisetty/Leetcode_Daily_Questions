// Daily Problem 13th January

class Solution {
    public double separateSquares(int[][] squares) {
        List<double[]> l=new ArrayList<>();

        for (int[] i:squares)
        {
            int xi=i[1],yi=i[2];
            l.add(new double[]{xi,yi});
            l.add(new double[]{xi+yi,-yi});
        }

        l.sort((a, b) -> Double.compare(a[0], b[0]));

        double total=0.0;
        for (int[] i:squares)
        {
            int xi=i[2];
            total+=(double)xi*xi;
        }

        double target=total/2.0;
        double cur=l.get(0)[0],curr=0.0,accumulated=0.0;

        for(int i=0;i<l.size();i++)
        {
            double[] event=l.get(i);
            double y=event[0],change=event[1];
            double sep=y-cur;
            accumulated+= curr*sep;
            if(accumulated >= target)
            {
                double prev=accumulated-curr*sep;
                double need=target-prev;
                return cur+need/curr;
            }
            cur=y;
            curr+=change;
        }
        return 0.0;
    }
}