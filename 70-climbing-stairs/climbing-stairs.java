import java.util.Arrays;

class Solution {

    int[] dp;

    int solve(int n) {

        // BASE CASE
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        // MEMOIZATION
        if (dp[n] != -1)
            return dp[n];

        // RECURRENCE
        return dp[n] = solve(n - 1) + solve(n - 2);
    }

    public int climbStairs(int n) {

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return solve(n);
    }
}