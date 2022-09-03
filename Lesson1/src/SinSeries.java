public class SinSeries {
    private static double sin(double x, double eps) {
        return 0;
    }

    private static double equation(double n, double eps) {

        double b = n;
        if (n > 0) {
            while ((Math.abs(b) >= Math.PI)) {
                b -= Math.PI * 2;
            }
        } else while ((Math.abs(b) >= Math.PI)) {
            b += Math.PI * 2;
        }
//        System.out.println("n после уменьшения на 2*PI= " + b);

        if (b > Math.PI / 2) {
            b = -(b - Math.PI);
        } else {
            if (b < -Math.PI / 2) {
                b = -(b + Math.PI);
            }
        }
//        System.out.println("n после уменьшения= " + b);

        double z = 1;
        double s = b;
        double a = 1;
        double y=b;

        do {

            y=-(y*b*b/((2*a+1)*2*a));

//            double y =Math.pow(a,b);

//            for (double c = 1; c <= 2 * a + 1; c++) {
//                z *= c;
//            }

//            y = (Math.pow(-1, a) * Math.pow(b, (2 * a + 1))) / z;


            s += y;

//            System.out.println("a= " + a + " z= " + z + " y=" + y + " s=" + s);

            a++;
        } while (Math.abs(y) > eps);
        return s;
    }

    public static void main(String[] args) {
        double result = equation(1.5, 1e-100);
        System.out.println("func= " + result);
    }
}
