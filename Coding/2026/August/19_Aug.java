// Daily Problem 19th August

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int l=0,r=0,prev=0;
        int size=reservedSeats.length;
        Arrays.sort(reservedSeats,(a,b)->a[0]-b[0]);
        boolean[] b=new boolean[11];
        int res=0;
        while(r<size)
        {
            res+=2*(reservedSeats[r][0]-prev-1);
            prev=reservedSeats[r][0];
            while(r<size && reservedSeats[l][0]==reservedSeats[r][0])
            {
                b[reservedSeats[r][1]]=true;
                r++;
            }
            boolean twoToFive=check(b,2,5);
            boolean fourToSeven=check(b,4,7);
            boolean sixToNine=check(b,6,9);

            if(twoToFive && sixToNine)
            {
                res+=2;
            }

            else if(twoToFive || fourToSeven || sixToNine)
            {
                res+=1;
            }
            l=r;
            Arrays.fill(b, false);
        }

        res+=2*(n-prev);
        return res;
    }

    public boolean check(boolean[] b, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (b[i]) {
                return false;
            }
        }
        return true;
    }
}