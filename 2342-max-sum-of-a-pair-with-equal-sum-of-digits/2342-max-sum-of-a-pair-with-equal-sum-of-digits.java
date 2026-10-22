class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int temp = num;
            int key = 0;

            while (temp > 0) {
                key += temp % 10;
                temp /= 10;
            }

            map.putIfAbsent(key, new PriorityQueue<>(Collections.reverseOrder()));
            map.get(key).offer(num);
        }
        int maxSum = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() >= 2) {
                int sum = pq.poll() + pq.poll();
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}