class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int num = 26 - (s.charAt(i) - 'a');
            sum += num * (i + 1);
        }
        return sum;
    }
}