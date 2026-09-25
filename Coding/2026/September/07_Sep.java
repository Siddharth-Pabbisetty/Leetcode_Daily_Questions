// Daily Problem 7th September

class Solution {
    int MOD=1000000007;
    public int distinctSubseqII(String s) {
        int total=0;
        int[] arr=new int[26];
        for (int i=0;i<s.length();i++)
        {
            int c=s.charAt(i)-97;
            int add=(total-arr[c]+MOD)%MOD;
            arr[c]=1+total;
            total=(arr[c]+add)%MOD;
        }
        return total;
    }
}