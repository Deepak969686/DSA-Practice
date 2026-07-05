class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n1>n2) return false;
        int[] prefix=new int[n1+1];
        int matchedprefix=0,j=0;
        for(int i=0;i<n1;i++){
            while(j<n2 && t.charAt(j)!=s.charAt(i)) j++;
            if(j==n2) break;
            j++;
            matchedprefix=i+1;
            prefix[i+1]=j;
        }
        if(matchedprefix==n1) return true;
        int[] suffix=new int[n1+1];
        suffix[n1]=n2;
        int matchedsuffix=0,jj=n2-1;
        for(int i=n1-1;i>=0;i--){
            while(jj>=0 && t.charAt(jj)!=s.charAt(i)) jj--;
            if(jj<0) break;
            suffix[i]=jj;
            jj--;
            matchedsuffix=n1-i;
        }
        for(int k=0;k<n1;k++){
            boolean prefixok=k<=matchedprefix;
            boolean suffixok=(k+1==n1) || (n1-(k+1)<=matchedsuffix);
            if(prefixok && suffixok && prefix[k]<suffix[k+1]) return true;
        }
        return false;
    }
}