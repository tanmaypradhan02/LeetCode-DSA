class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] preGcd = new int[n];
        int max = -1;
        for(int i=0;i<n;i++){
            if(max<nums[i]) max = nums[i];
            preGcd[i] = gcd(max, nums[i]);
        }
        Arrays.sort(preGcd);
        long sum = 0;
        int i = 0;
        int j = n-1;
        while(i<j){
            sum += gcd(preGcd[i], preGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}