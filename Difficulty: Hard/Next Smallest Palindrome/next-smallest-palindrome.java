class Solution {
    public int[] nextPalindrome(int[] num) {
        int n = num.length;
        int[] a = num.clone();

        for (int i = 0; i < n / 2; i++)
            a[n - 1 - i] = a[i];

        if (isGreater(a, num)) return a;

        int i = (n - 1) / 2, j = n / 2, carry = 1;

        while (i >= 0 && carry > 0) {
            int sum = a[i] + carry;
            a[i] = sum % 10;
            a[j] = a[i];
            carry = sum / 10;
            i--; j++;
        }

        if (carry > 0) {
            int[] res = new int[n + 1];
            res[0] = res[n] = 1;
            return res;
        }

        return a;
    }

    private boolean isGreater(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return a[i] > b[i];
        return false;
    }
}