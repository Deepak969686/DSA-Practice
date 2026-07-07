class Solution {
    public long sumAndMultiply(int n) {
        long nonzero =0; 
        long sum = 0;
        int i=1;
        while (n > 0) {
            long digit=n%10;
            n/=10;
            if(digit==0) continue;
            sum+=digit;
            nonzero=nonzero+(digit*i);

            i*=10;
        }
        return nonzero*sum;
    }
}



// class Solution {
//     public long sumAndMultiply(int n) {
//         long nonZero = reverseWithoutZero(n);
//         long temp = nonZero;
//         long sum = 0;
//         while (temp > 0) {
//             sum += temp % 10;
//             temp /= 10;
//         }
//         long reverseAgain = reverseWithoutZero(nonZero);
//         return reverseAgain * sum;
//     }
//     private long reverseWithoutZero(long num) {
//         long reverse = 0;
//         while (num > 0) {
//             long digit = num % 10;
//             if (digit != 0) {
//                 reverse = reverse * 10 + digit;
//             }
//             num /= 10;
//         }
//         return reverse;
//     }
// }