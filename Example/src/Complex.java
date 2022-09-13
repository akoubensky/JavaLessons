import java.util.Objects;

public class Complex implements Comparable<Complex> {

    @Override
    public int compareTo(Complex c) {
//        if (re<c.re) {
//            return -1;
//        } else if (re>c.re) {
//            return 1;
//        } else if (im>c.im) {
//            return 1;
//        } else if (im<c.im) {
//            return -1;
//        }
//        return 0;
        return Double.compare(re,c.re)==0?Double.compare(im,c.im):Double.compare(re,c.re);
    }

    public int compareToSwitch (Complex c) {
        return switch (Double.compare(re,c.re)) {
            case 0->Double.compare(im,c.im);
            case 1,-1->Double.compare(re,c.re);
            default -> 0;
        };
    }

    private double re;
   private double im;

   public Complex (double re, double im) {
        this.re=re;
        this.im=im;
    }
   public Complex () {
        this (0,0);
    }
   public Complex (double re) {
        this (re,0);
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

    // Наша задача: реализовать операции над комплексными числами:
    // сложение, вычитание, умножение, вычисление модуля и аргумента.
    public static Complex add (Complex a, Complex b) {
       return new Complex(a.re+ b.re,a.im+ b.im);
    }
    public Complex add (Complex b) {
        String s="Hello";
        switch (s) {
            case "Hello" -> {
                System.out.println(s);
            }
            default -> System.out.println(" ");
        }

        return new Complex(this.re+ b.re,this.im+ b.im);
//        this можно убрать.
    }
    public Complex sum (Complex b) {
       return add(this,b);
    }
    public static Complex sum (Complex a, Complex b) {
       return a.add(b);
    }
//    написать методы для других операций с комплексными числами.
//    Это ветка от 07.23 Example

// TODO Вычитание
    public static Complex sub (Complex a, Complex b) {
        return new Complex(a.re- b.re,a.im- b.im);
    }
    public Complex sub (Complex b) {
        return new Complex(this.re- b.re,this.im- b.im);
//        this можно убрать.
    }
    public Complex dif (Complex b) {
        return sub(this,b);
    }
    public static Complex dif (Complex a, Complex b) {
        return a.sub(b);
    }

// TODO Умножение
    public static Complex mul (Complex a, Complex b) {
        return new Complex((a.re* b.re)-(a.im* b.im),(a.im* b.re)+ (a.re* b.im));
    }
    public Complex mul (Complex b) {
        return new Complex((re* b.re)-(im* b.im),(im* b.re)+ (re* b.im));
//        this можно убрать.
    }
    public Complex com (Complex b) {
        return mul(this,b);
    }
    public static Complex com (Complex a, Complex b) {
        return a.mul(b);
    }

// TODO Модуль
    public static double mod (Complex a) {
       double r= Math.sqrt((a.re* a.re)+(a.im* a.im));
       return r;
//       Не получается вернуть значение строкой return double Math.sqrt((a.re* a.re)+(a.im* a.im));
    }
    public double mod () {
        double r= Math.sqrt((re* re)+(im* im));
        return r;
    }
    public double modul () {
        return mod(this);
    }
    public static double modul (Complex a) {
        return mod(a);
    }

// TODO Аргумент
    public static double arg (Complex a) {
        double j = Math.atan(a.im/ a.re);
        return j;
    }
    public double arg () {
        double j = Math.atan(im/ re);
        return j;
    }
    public double argum () {
        return arg(this);
    }
    public static double argum (Complex a) {
        return arg(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return re==complex.re && im==complex.im;
    }
    public int hashCode () {
       return Objects.hash(re,im);
    }

}

