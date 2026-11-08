// Daily Problem 20th October

class Solution {
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int[] desc=new int[n];
        for(int i=1;i<n;i++)
        {
            desc[i]=desc[i-1]+(nums[i-1]>nums[i]?1:0);
        }
        int[] premax=nums.clone();
        int[] sufmin=nums.clone();
        Arrays.parallelPrefix(premax, Math::max);
        for(int i=n-2;i>=0;i--)
        {
            sufmin[i]=Math.min(sufmin[i],sufmin[i+1]);
        }
        boolean[] cut=new boolean[n];
        cut[0]=true;
        for(int i=1;i<n;i++)
        {
            cut[i]=premax[i-1]<=sufmin[i];
        }
        BiPredicate<Integer, Integer> rotatable = (l, r) ->desc[r] - desc[l] + (nums[r] > nums[l] ? 1 : 0) <= 1;
        IntPredicate sortable = k ->
                IntStream.iterate(0, l -> l < n, l -> l + k).allMatch(l -> cut[l] && rotatable.test(l, l + k - 1));

        IntStream divisors = IntStream.rangeClosed(1, n).filter(k -> n % k == 0);
        return divisors.filter(sortable).sum();
    }
}