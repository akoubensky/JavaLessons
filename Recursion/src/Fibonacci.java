public class Fibonacci {
    public static long fibonacci(int n) {
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
        if (n < 3) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static long fib1(int n) {
        long[] storage = new long[n];
        storage[0] = storage[1] = 1;
        for (int i = 2; i < n; i++) {
            storage[i] = storage[i-2] + storage[i-1];
        }
        return storage[n-1];
    }

    public static long fib2(int n) {
        long f1 = 1, f2 = 1;
        for (int i = 2; i < n; i++) {
            long f3 = f1 + f2;
            f1 = f2; f2 = f3;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(fib1(50));
        System.out.println(fib2(50));
    }
}
