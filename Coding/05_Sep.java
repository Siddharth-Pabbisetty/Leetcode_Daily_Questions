//Daily Problem 5th September

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 1; i <= 60; i++) {
            long cnt = 1L * num1 - 1L * num2 * i;
            if (cnt < i) {
                return -1;
            }
            if (i >= Long.bitCount(cnt)) {
                return i;
            }
        }
        return -1;
    }
}