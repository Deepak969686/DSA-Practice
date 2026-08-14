class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int k=s1.length();
        char[] cs1=s1.toCharArray();
        Arrays.sort(cs1);
        int left=0;
        for(int right=k-1;right<s2.length();right++){
            String str=s2.substring(right-k+1,right+1);
            char[] cs2=str.toCharArray();
            Arrays.sort(cs2);
            if(Arrays.equals(cs1,cs2)) return true;
        }
        return false;
    }
}