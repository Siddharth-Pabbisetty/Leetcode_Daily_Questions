// Daily Problem 19th October

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int l=(int) Arrays.stream(nums).filter(num->num<target).count();
        int r=(int) Arrays.stream(nums).filter(num->num<=target).count();
        return IntStream.range(l,r).boxed().toList();
    }
}