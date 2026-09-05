import java.util.Arrays;

class Solution {

    int[] t = new int[10001];

    int solve(int[] nums, int n, int idx) {

        if (idx == n - 1)
            return 0;

        if (t[idx] != -1)
            return t[idx];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx] && idx + i < n; i++) {

            int result = solve(nums, n, idx + i);

            if (result != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + result);
            }
        }

        return t[idx] = ans;
    }

    public int jump(int[] nums) {

        Arrays.fill(t, -1);

        return solve(nums, nums.length, 0);
    }
}