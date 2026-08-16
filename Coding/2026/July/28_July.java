// Daily Problem 28th July

class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int j=0;
        int[] freq=new int[26];
        char[] arr=s.toCharArray();
        for(int i=0;i<n>>1;i++) {
            freq[(arr[i]&31)-1]++;
        }
        for(int i=0;i<26;i++)
        {
            while(freq[i]-->0)
            {
                arr[j]=(char)(97+i);
                arr[n-1-j++]=(char)(97+i);
            }
        }
        return new String(arr);
    }
}