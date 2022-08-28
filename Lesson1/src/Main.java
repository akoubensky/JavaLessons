public class Main {
    private static double func(double x) {
        return x * Math.sin(x) - 1;
    }

    private static double equation(double a, double b, double eps) {
        do {
            double m = (a + b) / 2;
            if (func(m) > 0) a = m; else b = m;
        } while (b - a > eps);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(func(Math.PI/2));
        System.out.println(func(Math.PI));
        double result = equation(Math.PI/2, Math.PI, 1e-5);
        System.out.println(result);
        System.out.println(func(result));
    }
}

