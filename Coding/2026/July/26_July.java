// Daily Problem 26th July

class Solution {
    public int maximumProduct(int[] nums) {
        int a=-1001;
        int b=a;
        int c=b;
        int x=1001;
        int y=x;
        for(int i:nums)
        {
            int min_a=a,min_b=b,min_x=x;
            a=Math.max(a,i);
            b=Math.max(b,Math.min(min_a,i));
            c=Math.max(c,Math.min(min_b,i));
            x=Math.min(x,i);
            y=Math.min(y,Math.max(min_x,i));
        }
        return Math.max(a*b*c,a*x*y);
    }
}