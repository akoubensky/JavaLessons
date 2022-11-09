package ru.unecon.complex;

import java.util.Objects;

public class Complex {
    private final double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex() {
        this(0,0);
    }

    public Complex(double re) {
        this(re, 0);
    }

    public double re() { return re; }
    public double im() { return im; }
    public double mod() { return Math.sqrt(re*re + im*im); }

    public static final Complex ZERO = new Complex();
    public static final Complex ONE = new Complex(1);
    public static final Complex I = new Complex(0, 1);

    public static Complex plus(Complex c1, Complex c2) {
        return new Complex(c1.re + c2.re, c1.im + c2.im);
    }

    public static Complex minus(Complex c1, Complex c2) {
        return new Complex(c1.re - c2.re, c1.im - c2.im);
    }

    public Complex plus(Complex c) {
        return plus(this, c);
    }

    public Complex minus(Complex c) {
        return minus(this, c);
    }

    @Override
    public String toString() {
        return "(" + re + (im == 0 ? "" : im < 0 ? "-" + -im + "i" : "+" + im + "i") + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return complex.re == re && complex.im == im;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}
