class Solution {
    int index = 0;
    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        while(index < s.length() && s.charAt(index) != '}') {
            Set<String> curr = parseTerm(s);
            // Union
            result.addAll(curr);
            // If comma, skip it and parse next expression
            if(index < s.length() && s.charAt(index) == ',') {
                index++;
            }
        }
        return result;
    }
    Set<String> parseTerm(String s) {
        Set<String> result = new HashSet<>();
        result.add("");
        while(index < s.length()
              && s.charAt(index) != ','
              && s.charAt(index) != '}') {
            Set<String> next = parseFactor(s);
            Set<String> temp = new HashSet<>();
            // Concatenation
            for(String a : result) {
                for(String b : next) {
                    temp.add(a + b);
                }
            }
            result = temp;
        }
        return result;
    }
    Set<String> parseFactor(String s) {
        Set<String> result = new HashSet<>();
        // { ... }
        if(s.charAt(index) == '{') {
            index++; // skip '{'
            result = solve(s);
            index++; // skip '}'
        }
        // letter
        else {
            result.add(String.valueOf(s.charAt(index)));
            index++;
        }
        return result;
    }
}