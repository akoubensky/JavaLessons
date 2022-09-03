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
}

