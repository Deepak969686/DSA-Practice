class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list);
        int last = list.get(list.size() - 1);
        int secondLast = list.get(list.size() - 2);
        return last*secondLast;
    }
}