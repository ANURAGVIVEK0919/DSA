class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // For-loop wale code mein 0 se shuru karenge
        backtrack(candidates, target, 0, new ArrayList<>());
        
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> current) {

        // Base Case: Agar target 0 ho gaya, matlab answer mil gaya
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Agar target minus me chala gaya, toh aage check karne ki zaroorat nahi
        if (target < 0) {
            return;
        }

        // Remaining elements ko loop se try karo
        for (int i = index; i < candidates.length; i++) {

            // Choose: Element ko list me daalo
            current.add(candidates[i]);

            // Explore: Agli call me hum 'i' hi bhej rahe hain (i + 1 nahi)
            // Kyunki hum same number ko baar-baar use kar sakte hain!
            backtrack(candidates, target - candidates[i], i, current);

            // Undo (Backtrack): Element ko hatao taaki doosra try kar sakein
            current.remove(current.size() - 1);
        }
    }
}
