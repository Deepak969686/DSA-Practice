class Solution {
    int n;
    List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        n=s.length();
        solve(0,0,s,"");
        return ans;
    }
    void solve(int index, int parts, String s, String curr) {
        // 4 parts created
        if(parts == 4) {
            if(index == s.length()) {
                ans.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }
        // Try taking 1, 2, or 3 digits
        for(int len = 1; len <= 3; len++) {
            if(index + len > s.length()) break;
            String part = s.substring(index, index + len);
            // Leading zero is not allowed
            if(part.length() > 1 && part.charAt(0) == '0') continue;
            // Value must be <= 255
            if(Integer.parseInt(part) > 255) continue;
            solve(index + len, parts + 1, s, curr + part + ".");
        }
    }
}