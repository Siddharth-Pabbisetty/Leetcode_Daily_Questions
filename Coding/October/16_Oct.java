//Daily problem of 16th october

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int ans = 0;
        int[] arr = new int[value];
        for (int i : nums)
        {
            int rem = ((i % value) + value) % value;
            arr[rem]++;
        }
        while (arr[ans % value]-- > 0)
            ans++;
        return ans;
    }
}