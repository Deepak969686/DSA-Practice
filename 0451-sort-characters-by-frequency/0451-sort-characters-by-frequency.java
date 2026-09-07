class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }
        String ans = "";
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            for (int i = 0; i < curr.getValue(); i++) {
                ans += curr.getKey();
            }
        }
        return ans;
    }
}