import java.util.Arrays;

class Solution {

    int[] dp;
    int[] cost;

    int solve(int i) {

        // BASE CASE
        if (i == 0)
            return cost[0];

        if (i == 1)
            return cost[1];

        // MEMOIZATION
        if (dp[i] != -1)
            return dp[i];

        // RECURRENCE
        return dp[i] = cost[i] +
                Math.min(
                    solve(i - 1),
                    solve(i - 2)
                );
    }

    public int minCostClimbingStairs(int[] cost) {

        this.cost = cost;

        int n = cost.length;

        dp = new int[n];

        Arrays.fill(dp, -1);

        return Math.min(
            solve(n - 1),
            solve(n - 2)
        );
    }
}