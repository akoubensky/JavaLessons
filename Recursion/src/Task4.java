/**
 * Ќаписать функцию дл€ "быстрого" возведени€ целого числа в натуральную степень.
 * –екурси€ основана на том, что дл€ четной степени a ^ (2n) = (a ^ 2) ^ n, а дл€ нечетной степени a ^ (2n + 1) = a * a^2n     2^3=2^(2+1)=2^1*2^2=2*2^2
 * «десь символом ^ обозначена операци€ возведени€ в степень (такой операции в Java нет!)
 */
public class Task4 {
    private static int pow(int base, int power) {
        if (power==0) {
            return 1;
        }
        if (power%2!=0) {
            return base*pow(base,power-1);
        } else {
            return pow(base*base,power/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(3, 10));
        // ƒолжна напечатать 59049 : 3 в дес€той степени
    }
}
