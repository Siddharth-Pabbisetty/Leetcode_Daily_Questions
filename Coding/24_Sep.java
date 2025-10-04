//Daily Problem 24th September

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder ans = new StringBuilder();
        if (numerator < 0 ^ denominator < 0)
            ans.append("-");

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        ans.append(dividend/divisor);
        long rem = dividend%divisor;
        if (rem == 0)
        {
            return ans.toString();
        }

        ans.append(".");
        Map<Long, Integer> mp = new HashMap<>();
        while (rem != 0) {
            if (mp.containsKey(rem))
            {
                ans.insert(mp.get(rem), "(");
                ans.append(")");
                break;
            }
            mp.put(rem, ans.length());
            rem *= 10;
            ans.append(rem / divisor);
            rem %= divisor;
        }

        return ans.toString();
    }
}
