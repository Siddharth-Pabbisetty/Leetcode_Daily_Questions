// Daily Problem 14th August

class Solution {
    public int maximumLengthSubstring(String s) {
        int ans=0;
        int[] arr=new int[26];
        for(int i=0,j=0;j<s.length();j++)
        {
            arr[(s.charAt(j)&31)-1]++;
            while(arr[(s.charAt(j)&31)-1]>2)
            {
                arr[(s.charAt(i++)&31)-1]--;
            }
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}