// Daily Problem 30th June

class Solution {
    public int numberOfSubstrings(String s) {
        int res=0;
        int[] arr={-1, -1, -1};
        for(int i=0;i<s.length();i++)
        {
            arr[(s.charAt(i)&31)-1] = i;
            res+=Math.min(arr[0],Math.min(arr[1],arr[2]))+1;
        }
        return res;
    }
}