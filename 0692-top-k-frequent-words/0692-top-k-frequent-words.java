class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq =new PriorityQueue<>((a, b) -> {
                if (!a.getValue().equals(b.getValue()))
                    return b.getValue() - a.getValue();
                return a.getKey().compareTo(b.getKey());
            });
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> curr = pq.poll();
            ans.add(curr.getKey());
        }
        return ans;
    }
}