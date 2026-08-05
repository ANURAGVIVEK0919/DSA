class Solution {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int number : nums) {

            // If no candidate exists, choose current number
            if (count == 0) {
                candidate = number;
            }

            // Same candidate -> gain one vote
            if (number == candidate) {
                count++;
            }
            // Different number -> cancel one vote
            else {
                count--;
            }
        }

        return candidate;
    }
}