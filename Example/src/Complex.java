public class Complex {
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
    // сложение, вычитание, умножение, вычисление модуля и аргумента
    public static Complex add (Complex a, Complex b) {
       return new Complex(a.re+ b.re,a.im+ b.im);
    }
    public Complex add (Complex b) {
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
}

