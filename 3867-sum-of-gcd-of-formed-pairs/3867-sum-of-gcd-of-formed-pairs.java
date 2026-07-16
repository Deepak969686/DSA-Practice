class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] pregcd = new int[n];
        max[0] = nums[0];
        pregcd[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
            pregcd[i] = gcd(max[i], nums[i]);
        }
        Arrays.sort(pregcd);
        int l = 0;
        int r = n - 1;
        long ans = 0;

        while (l < r) {
            ans += (long) gcd(pregcd[l], pregcd[r]);
            l++;
            r--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        // return (b == 0) ? a : gcd(b, a % b);
    }
}