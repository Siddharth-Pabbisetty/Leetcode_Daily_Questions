//Daily Problem 8th September

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++)
        {
            int fNum=i;
            int sNum=n-i;
            if(fNum>0 && sNum>0 && !containsZero(fNum) && !containsZero(sNum))
            {
                return new int[]{fNum,sNum};
            }
        }
        return new int[]{-1,-1};
    }

    public boolean containsZero(int n){
        while(n>0){
            int r=n%10;
            if(r==0)
                return true;
            n/=10;
        }
        return false;
    }
}