class Solution {
    public int maxProduct(int n) {
        int[] digits = new int[10];
        int size = 0;

        while (n > 0) {
            digits[size] = n % 10;
            size++;
            n /= 10;
        }

        int max = 0;

        // Check every pair
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int product = digits[i] * digits[j];
                if (product > max) {
                    max = product;
                }
            }
        }

        return max;
    }
}