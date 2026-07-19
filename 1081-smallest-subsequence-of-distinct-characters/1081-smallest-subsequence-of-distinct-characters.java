class Solution {
    public String smallestSubsequence(String s) {
              int n=s.length();
        Stack<Character> st = new Stack<>();
        int[] lastindex=new int[26];
        boolean[] take=new boolean[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            lastindex[ch-'a']=i;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(take[ch-'a']) continue;
            while(!st.isEmpty() && st.peek()>ch && lastindex[st.peek()-'a']>i){
                take[st.pop() - 'a'] = false;
            }
            st.push(ch);
            take[ch-'a']=true;
        }
        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}