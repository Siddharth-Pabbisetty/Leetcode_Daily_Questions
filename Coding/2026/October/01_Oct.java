// Daily Problem 1st October

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1)
        {
            return false;
        }
        char[] arr=s.toCharArray();
        int i=0;
        for(char j:arr)
        {
            if((j&3)!=1)
            {
                arr[i++]=j;
            }
            else if(i==0 || ((j-arr[--i]+1)>>1)!=1)
            {
                return false;
            }
        }
        return i==0;
    }
}