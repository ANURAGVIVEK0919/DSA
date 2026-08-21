class Solution {

    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs",
        "tuv", "wxyz"
    };

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return ans;

        StringBuilder current = new StringBuilder();

        backtrack(digits, 0, current);

        return ans;
    }

    private void backtrack(String digits, int index,
                           StringBuilder current) {

        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            // ADD
            current.append(ch);

            // EXPLORE
            backtrack(digits, index + 1, current);

            // REMOVE
            current.deleteCharAt(current.length() - 1);
        }
    }
}