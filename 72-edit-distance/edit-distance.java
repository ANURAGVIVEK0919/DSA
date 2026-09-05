class Solution {
    int[][] t = new int[501][501];
    int m, n;

    public int solve(String s1, String s2, int i, int j) {
        if (i == m)
            return n - j;
        else if (j == n)
            return m - i;

        if (t[i][j] != -1)
            return t[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return t[i][j] = solve(s1, s2, i + 1, j + 1);
        else {
            int insertC = 1 + solve(s1, s2, i, j + 1);
            int deleteC = 1 + solve(s1, s2, i + 1, j);
            int replaceC = 1 + solve(s1, s2, i + 1, j + 1);

            return t[i][j] = Math.min(Math.min(insertC, deleteC), replaceC);
        }

    }

    public int minDistance(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        for (int[] row : t)
            Arrays.fill(row, -1);

        return solve(s1, s2, 0, 0);
    }
}