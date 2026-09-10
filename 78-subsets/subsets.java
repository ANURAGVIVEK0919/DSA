class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer>  current = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums, 0, current);

        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current) {

        // Current subset ko answer me add karo
        result.add(new ArrayList<>(current));
        

        // Remaining elements ko try karo
        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current);

            // Undo (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}