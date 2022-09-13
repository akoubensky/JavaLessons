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
        System.out.println(c5+"\n");

        Complex c6 = Complex.sub(c1, c2);
        System.out.println("c6: "+c6);
        Complex c7 = c1.sub(c2);
        System.out.println("c7: "+c7);
        Complex c8=Complex.dif(c1,c2);
        System.out.println("c8: "+c8);
        Complex c9=c1.dif(c2);
        System.out.println("c9: "+c9+"\n");

        double c10=Complex.mod(c1);
        double c11=c1.mod();
//        в с10 приходится указывать класс и за того, что метод статический?
//        а в с11 не нужно указывать класс из за того, что метод динамический и мы работаем с обьектом
//        этого класса?
        double c12=Complex.modul(c1);
//        В с 13 статический метод но класс мы не указываем?
        double c13=c1.modul();
        System.out.print("c10: "+c10+"\n"+"c11: "+c11+"\n"+"c12: "+c12+"\n"+"c13: "+c13+"\n"+"\n");

        double c14=Complex.arg(c1);
        double c15=c1.arg();
        double c16=Complex.argum(c1);
        double c17=c1.argum();
        System.out.print("c14: "+c14+"\n"+"c15: "+c15+"\n"+"c16: "+c16+"\n"+"c17: "+c17+"\n"+"\n");

        Complex c21=new Complex(1,1);
        Complex c22=new Complex(1,1);
        if (c21.equals(c22)) System.out.println("c21==c22");
        else System.out.println("c21!=c22");

        System.out.println(c21.hashCode()+" "+c22.hashCode());
    }
}
