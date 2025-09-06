// Daily Problem 1st September
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() 
                                                         {
            public int compare(double[] a, double[] b) {
                if (a[0] < b[0]) 
                    return 1;
                if (a[0] > b[0]) 
                    return -1;
                return 0;
            }
        });

        int n = classes.length;
        for (int i = 0; i < n; i++) 
        {
            double p = classes[i][0];
            double tot = classes[i][1];
            double inc = (p + 1.0) / (tot + 1.0) - p / tot;
            pq.offer(new double[]{inc, p, tot});
        }

        while (extraStudents > 0) 
        {
            double[] top = pq.poll();
            double p = top[1] + 1;
            double tot = top[2] + 1;
            double inc = (p + 1.0) / (tot + 1.0) - p / tot;
            pq.offer(new double[]{inc, p, tot});
            extraStudents--;
        }

        double ans = 0.0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) 
        {
            double[] c = (double[]) arr[i];
            ans += c[1] / c[2];
        }

        return ans/n;
    }
}
