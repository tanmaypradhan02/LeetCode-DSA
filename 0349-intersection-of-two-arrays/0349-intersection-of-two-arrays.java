class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] present = new boolean[1001];

        // Mark elements of nums1
        for (int num : nums1) {
            present[num] = true;
        }

        // Store intersection
        int[] temp = new int[1001];
        int count = 0;

        for (int num : nums2) {
            if (present[num]) {
                temp[count++] = num;
                present[num] = false; // avoid duplicates
            }
        }

        // Create result array of exact size
        int[] ans = new int[count];

        for (int i = 0; i < count; i++) {
            ans[i] = temp[i];
        }

        return ans;
    }
}