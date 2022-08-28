import java.util.Random;

public class Guess {
    private static int answer = 0;
    private static int memory(int x) {
        if (answer == 0) {
            answer = new Random().nextInt(100) + 1;
        }
        return x < answer ? -1 : x > answer ? 1 : 0;
    }

    public static void main(String[] args) {
        int a = 1, b = 100;
        do {
            int m = (a+b)/2;
            // a <= m < b
            int r = memory(m);
            if (r < 0) {
                // Середина меньше задуманного
                a = m + 1;
            } else {
                // Середина больше или равна задуманного
                b = m;
            }
        } while (a < b);
        System.out.println("Guess = " + a + ", answer = " + answer);
    }
}
