// Daily Problem 7th March

class Solution {
    public int minFlips(String s) {
        int n=s.length();
        int ans=n;
        int[] arr={0, 0};
        for(int i=0;i<n;i++)
        {
            arr[(s.charAt(i)^i) & 1]++;
        }

        for(int i=0;i<n;i++)
        {
            arr[(s.charAt(i)^i) & 1]--;
            arr[(s.charAt(i)^(n+i)) & 1]++;
            ans=Math.min(ans,Math.min(arr[0],arr[1]));
        }
        return ans;
    }
}