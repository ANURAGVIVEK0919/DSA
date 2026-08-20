class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> current) {
        // 1. Agar target 0 ho gaya, matlab answer mil gaya
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // 2. Loop ke upar check: agar target negative ho gaya, toh yahin se laut jao
        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Duplicate check (Ab yahan target check karne ki zarurat nahi hai)
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            // Agar nums[i] target se bada hoga, toh agle step mein target < 0 ho jayega
            backtrack(nums, target - nums[i], i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
