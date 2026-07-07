class Solution {
    public long sumAndMultiply(int n) {
        long nonZero = reverseWithoutZero(n);
        long temp = nonZero;
        long sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        long reverseAgain = reverseWithoutZero(nonZero);
        return reverseAgain * sum;
    }
    private long reverseWithoutZero(long num) {
        long reverse = 0;
        while (num > 0) {
            long digit = num % 10;
            if (digit != 0) {
                reverse = reverse * 10 + digit;
            }
            num /= 10;
        }
        return reverse;
    }
}