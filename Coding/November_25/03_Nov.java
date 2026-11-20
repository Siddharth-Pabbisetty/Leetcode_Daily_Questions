// Daily Problem 3rd November

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int total=0, curr=0;
        for(int i=0;i<colors.length();i++)
        {
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1))
            {
                curr=0;
            }
            total=total+Math.min(curr,neededTime[i]);
            curr=Math.max(curr,neededTime[i]);
        }

        return total;
    }
}
