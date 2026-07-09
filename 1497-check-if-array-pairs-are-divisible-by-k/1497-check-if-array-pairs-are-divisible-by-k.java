class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq=new int[k];
        for(int num:arr){
            int rem=(num%k+k)%k;
            freq[rem]++;
        }
        if(freq[0]%2!=0) return false;
        for(int rem=1;rem<=k/2;rem++){
            int counterhalf=k-rem;
            if(freq[counterhalf]!=freq[rem]) return false;
        }
        return true;
    }
}