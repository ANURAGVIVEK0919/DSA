class Solution {

    public int longestPalindrome(String s) {

        int[] frequency = new int[128];

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            frequency[ch]++;
        }

        int palindromeLength = 0;
        boolean hasOdd = false;

        // Step 2: Build answer
        for (int count : frequency) {

            if (count % 2 == 0) {
                palindromeLength += count;
            } else {
                palindromeLength += count - 1;
                hasOdd = true;
            }
        }

        // Step 3: Put one odd character in center
        if (hasOdd) {
            palindromeLength++;
        }

        return palindromeLength;
    }
}