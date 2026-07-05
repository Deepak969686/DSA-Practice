class Solution {
    public int minOperations(String s1, String s2) {
        int n=s1.length();
        if(n==1) {
            if(s1.equals(s2)) return 0;
            return s1.charAt(0)=='0'?1:-1;
        }
        long ans=0;
        int i=0;
        while(i<n){
            char c1=s1.charAt(i),c2=s2.charAt(i);
            if(c1=='0' && c2=='1'){
                ans++;
                i++;
            } else if(c1=='1' && c2=='0'){
                int j=i;
                while(j<n && s1.charAt(j)=='1' && s2.charAt(j)=='0') j++;
                int len=j-i;
                ans+=len/2+(len%2)*2;
                i=j;
            } else{
                i++;
            }
        }
        return (int) ans;
    }
}