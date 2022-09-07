public class Example {
    public static void main(String[] args) {
        Complex c1=new Complex(1,1);
        Complex c2= new Complex(2);
        System.out.println(c1);
        System.out.println(c2.getRe());

        // Если мы реализуем операции сложения и умножения, то сможем написать:
        Complex c3 = Complex.add(c1, c2);
        System.out.println(c3);
//        Complex c4 = Complex.multiply(c2, c3);
        // или, скажем,
        Complex c5 = c1.add(c2);
        System.out.println(c5);
    }
}
