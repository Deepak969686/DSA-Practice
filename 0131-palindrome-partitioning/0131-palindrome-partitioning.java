class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }
    void solve(int start, String s, List<String> list, List<List<String>> ans) {
        if(start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = start; j < s.length(); j++) {
            String sub = s.substring(start, j + 1);
            if(isPalindrom(sub)) {
                list.add(sub);
                solve(j + 1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isPalindrom(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}