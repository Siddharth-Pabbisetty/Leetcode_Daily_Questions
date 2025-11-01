//Daily problem of 21th october

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 1;
        maxVal+=1;
        int[] cnt = new int[maxVal];

        for (int i : nums)
            cnt[i]++;

        for (int i = 1; i < maxVal; i++)
            cnt[i] += cnt[i - 1];

        int res = 0;
        for (int i = 0; i < maxVal; i++)
        {
            int left = Math.max(0, i - k);
            int right = Math.min(maxVal - 1, i + k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            res = Math.max(res, freq + Math.min(numOperations, total - freq));
        }

        return res;
    }
}