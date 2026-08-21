class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(0, s, path, ans);

        return ans;
    }

    private void backtrack(int start, String s,
                           List<String> path,
                           List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            if (isPalindrome(s, start, i)) {

                path.add(s.substring(start, i + 1));

                backtrack(i + 1, s, path, ans);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}