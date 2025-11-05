//Daily problem of 25th october

class Solution {
    public int totalMoney(int n) {
        int w=n/7;
        int d=n%7;

        int sum=(n*(n+1))/2;
        int weeks=(w*(w-1))/2;

        return sum-42*weeks-6*w*d;
    }
}