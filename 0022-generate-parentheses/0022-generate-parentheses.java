class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        String curr = "";
        solve(0, 0, curr, n);
        return res;
    }

    private void solve(int o, int c, String curr, int n) {
        if (curr.length() == 2*n) {
            if (o == c)
                res.add(curr);
            return;
        }
        if (o > c) {
            solve(o, c + 1, curr + ')', n);
        }
        solve(o + 1, c, curr + '(', n);
    }
}