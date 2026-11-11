class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidates, target, current, ans);

        return ans;
    }

    public void solve(int index, int[] candidates, int target,
                      List<Integer> current, List<List<Integer>> ans) {

        // Base case: Target achieved
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try all possible candidates
        for (int i = index; i < candidates.length; i++) {

            // Skip if candidate is greater than target
            if (candidates[i] > target) {
                continue;
            }

            // Choose the candidate
            current.add(candidates[i]);

            // Recursion: Same index because reuse is allowed
            solve(i, candidates, target - candidates[i], current, ans);

            // Backtracking: Remove the last element
            current.remove(current.size() - 1);
        }
    }
}