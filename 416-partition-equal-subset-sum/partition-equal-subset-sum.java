class Solution {
    int[][] t = new int[201][20001];

    boolean solve(int[] nums, int i, int x) {

        if (x == 0) return true;
        if (i >= nums.length) return false;

        // Already calculated
        if (t[i][x] != -1)
            return t[i][x] == 1;

        boolean take = false;

        if (nums[i] <= x)
            take = solve(nums, i + 1, x - nums[i]);

        boolean notTake = solve(nums, i + 1, x);

        // Store answer
        t[i][x] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        // Initialize memo table
        for (int[] row : t)
            java.util.Arrays.fill(row, -1);

        return solve(nums, 0, sum / 2);
    }
}