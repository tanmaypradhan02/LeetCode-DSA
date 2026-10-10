
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) {
            return 0;
        }

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long used = 0;
        long ans = 0;
        long count = 0;

        for (int d : diff) {
            if (d > limit) {
                used += d - limit;
                d = limit;
            }

            if (d == limit) {
                count++;
            }

            ans += (long) d * d;
        }

        long remaining = k - used;

        // Reduce remaining differences from limit to limit - 1
        long reduce = Math.min(remaining, count);

        ans -= reduce * ((long) limit * limit
                         - (long) (limit - 1) * (limit - 1));

        return ans;
    }
}
