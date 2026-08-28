class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n];

        dp[0] = 1;

        if (n >= 2) {

            // i = 1
            // Single: s[1]
            // Double: s[0]s[1]

            if (s.charAt(1) != '0') {
                dp[1] = dp[0];
            }

            int num = Integer.parseInt(s.substring(0, 2));

            if (num >= 10 && num <= 26) {
                dp[1] += 1;
            }
        }

        for (int i = 2; i < n; i++) {

            // Take current character alone
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }

            // Take current + previous character
            int num = Integer.parseInt(s.substring(i - 1, i + 1));

            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n - 1];
    }
}