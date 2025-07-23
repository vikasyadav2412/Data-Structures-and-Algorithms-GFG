import java.util.*;

class Solution {
    int cntCoprime(int[] arr) {
        int n = arr.length;
        int maxVal = 0;
        for (int x : arr) {
            if (x > maxVal) maxVal = x;
        }
        int[] freq = new int[maxVal + 1];
        for (int x : arr) {
            freq[x]++;
        }
        int[] multiples = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            for (int j = i; j <= maxVal; j += i) {
                multiples[i] += freq[j];
            }
        }
        int[] mobius = new int[maxVal + 1];
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= maxVal; j += i) {
                    isPrime[j] = false;
                    mobius[j] *= -1;
                }
                long sq = (long) i * i;
                if (sq <= maxVal) {
                    for (int j = (int) sq; j <= maxVal; j += sq) {
                        mobius[j] = 0;
                    }
                }
            }
        }
        long result = 0;
        for (int i = 1; i <= maxVal; i++) {
            if (mobius[i] != 0) {
                long c = multiples[i];
                result += mobius[i] * (c * (c - 1L) / 2);
            }
        }
        return (int) result;
    }
}
