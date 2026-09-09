class Solution {
    PriorityQueue<int[]> maxHeap =new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        });

    PriorityQueue<int[]> minHeap =
        new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
    boolean[] removed;
    int[] side; // 0 = maxHeap, 1 = minHeap
    int maxSize = 0;
    int minSize = 0;
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        removed = new boolean[n];
        side = new int[n];
        // First window
        for (int i = 0; i < k; i++) {
            add(nums[i], i);
        }
        balance();
        int j = 0;
        ans[j++] = getMedian(k);
        // Sliding window
        for (int i = k; i < n; i++) {
            // Remove old element
            remove(i - k);
            // Add new element
            add(nums[i], i);
            balance();
            ans[j++] = getMedian(k);
        }
        return ans;
    }
    void add(int num, int index) {
        int[] pair = {num, index};
        if (maxHeap.isEmpty() || num <= maxHeap.peek()[0]) {
            maxHeap.offer(pair);
            side[index] = 0;
            maxSize++;
        } else {
            minHeap.offer(pair);
            side[index] = 1;
            minSize++;
        }
    }
    void remove(int index) {
        removed[index] = true;
        // We know exactly which heap this index belongs to
        if (side[index] == 0) {
            maxSize--;
        } else {
            minSize--;
        }
        clean(maxHeap);
        clean(minHeap);
    }
    void clean(PriorityQueue<int[]> pq) {
        while (!pq.isEmpty() && removed[pq.peek()[1]]) {
            pq.poll();
        }
    }

    void balance() {
        clean(maxHeap);
        clean(minHeap);
        // maxHeap can have at most 1 extra element
        while (maxSize > minSize + 1) {
            int[] x = maxHeap.poll();
            minHeap.offer(x);
            side[x[1]] = 1;
            maxSize--;
            minSize++;
            clean(maxHeap);
        }

        while (maxSize < minSize) {
            int[] x = minHeap.poll();
            maxHeap.offer(x);
            side[x[1]] = 0;
            minSize--;
            maxSize++;
            clean(minHeap);
        }
    }

    double getMedian(int k) {
        clean(maxHeap);
        clean(minHeap);
        if (k % 2 == 1) {
            return maxHeap.peek()[0];
        }

        return ((double) maxHeap.peek()[0] + (double) minHeap.peek()[0]) / 2.0;
    }
}