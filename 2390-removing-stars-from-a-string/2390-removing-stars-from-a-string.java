class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch!='*') st.push(ch);
            else st.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String res = sb.reverse().toString();
        return res;
    }
}