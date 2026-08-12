class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] tails = new int[n];
        int size = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int pos = lowerBound(tails, size, height);
            tails[pos] = height;
            if (pos == size) {
                size++;
            }
        }
        return size;
    }
    private int lowerBound(int[] tails,int size,int target) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid =left + (right - left) / 2;
            if (tails[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}