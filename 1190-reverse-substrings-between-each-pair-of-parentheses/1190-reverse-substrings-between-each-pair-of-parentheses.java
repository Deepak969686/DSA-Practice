class Solution {
    int index = 0;
    public String reverseParentheses(String s) {
        return solve(s);
    }
    String solve(String s) {
        StringBuilder ans = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ')') {
            char ch = s.charAt(index);
            // Opening bracket
            if(ch == '(') {
                index++; // skip '('
                String temp = solve(s);
                index++; // skip ')'
                ans.append(new StringBuilder(temp).reverse());
            }
            // Normal character
            else {
                ans.append(ch);
                index++;
            }
        }
        return ans.toString();
    }
}