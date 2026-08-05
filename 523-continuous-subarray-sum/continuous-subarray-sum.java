class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> remainderMap = new HashMap<>();

        // Prefix sum = 0 before array starts
        remainderMap.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int remainder = prefixSum % k;

            if (remainderMap.containsKey(remainder)) {

                int previousIndex = remainderMap.get(remainder);

                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {

                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}