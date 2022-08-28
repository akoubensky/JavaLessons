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
        // Здесь будет Ваша реализация
    }
}
