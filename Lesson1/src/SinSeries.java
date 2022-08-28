public class SinSeries {
    private static double sin(double x, double eps) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(sin(Math.PI/2, 1e-10));
    }
}
