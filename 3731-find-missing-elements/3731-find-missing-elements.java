class Solution {
    public List<Integer> findMissingElements(int[] nums) {
         List<Integer> ans = new ArrayList<>();

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Mark existing numbers
        boolean[] present = new boolean[101];
        for (int num : nums) {
            present[num] = true;
        }

        // Find missing numbers
        for (int i = min; i <= max; i++) {
            if (!present[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}