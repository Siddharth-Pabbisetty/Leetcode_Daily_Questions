// Daily Problem 14th October

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num)
        {
            return "";
        }

        StringBuilder sb=new StringBuilder();
        int nines=sum/9;
        int r=sum%9;
        for(int i=0;i<nines;i++)
        {
            sb.append("9");
        }
        if(r!=0)
        {
            sb.append(r);
        }
        int zeros=num-nines;
        if(r!=0)
        {
            zeros--;
        }
        for(int i=0;i<zeros;i++)
        {
            sb.append("0");
        }
        return sb.toString();
    }
}