class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrack(result, current, 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result,
                            StringBuilder current,
                            int open,
                            int close,
                            int n) {

        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        // ADD (
        if (open < n) {
            current.append('(');

            // EXPLORE
            backtrack(result, current, open + 1, close, n);

            // REMOVE (
            current.deleteCharAt(current.length() - 1);
        }

        // ADD )
        if (close < open) {
            current.append(')');

            // EXPLORE
            backtrack(result, current, open, close + 1, n);

            // REMOVE )
            current.deleteCharAt(current.length() - 1);
        }
    }
}