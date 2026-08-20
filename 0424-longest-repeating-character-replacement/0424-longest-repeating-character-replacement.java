class Solution {
    public int characterReplacement(String s, int k) {
        int[] frq=new int[26];
        int maxfrq=0;
        int maxwindow=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            frq[s.charAt(right)-'A']++;
            maxfrq=Math.max(maxfrq,frq[s.charAt(right)-'A']);
            
            int windowlen=right-left+1;
            if(windowlen-maxfrq>k){
                frq[s.charAt(left)-'A']--;
                left++;
            }
            windowlen=right-left+1;
            maxwindow=Math.max(maxwindow,windowlen);
        }
        return maxwindow;
    }
}