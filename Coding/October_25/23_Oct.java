//Daily problem of 23rd october

class Solution {
    public boolean hasSameDigits(String s) {
        int[] a = new int[s.length()];
        for(int i=0;i<a.length;i++)
            a[i]=s.charAt(i)-'0';
        for(int i=a.length;i>2;i--)
        {
            for(int j=0;j<i-1;j++)
            {
                a[j]=(a[j]+a[j+1])%10;
            }
        }
        return a[0]==a[1];
    }
}