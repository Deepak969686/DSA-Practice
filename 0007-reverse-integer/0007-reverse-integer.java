class Solution {
    public int reverse(int x) {
        int sign=1;
        if(x<Integer.MIN_VALUE) return 0;
        if(x<0){
            sign=-1;
        }
        long rev=0;
        x=Math.abs(x);
        while(x>0){
            long digit=x%10;
            rev=rev*10+digit;
            if(rev>=Integer.MAX_VALUE) return 0;
            x/=10;
        }
        return (int)rev*sign;
    }
}