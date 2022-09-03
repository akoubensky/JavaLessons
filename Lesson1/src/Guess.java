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
        for (int i =0;i<10000;i++) {
            answer=0;

            int a = 1;
            int b = 100;
            int y;
            do {
                y = (b + a) / 2;
//                System.out.println(y);
                if (memory(y) == 1) {
                    b = y;
//                    System.out.println("b= " + b);
                } else {
                    if (memory(y) == -1) {
                        a = y+1;
//                        System.out.println("a= " + a);
                    }
                }
            } while (memory(y) != 0);
            System.out.println(y);
            System.out.println(answer);
        }
//        for (int y =0;y<=100;y++) {
//            System.out.println("y= "+y+" значение функции "+memory('y'));
//
//            if (memory('y')==0) break;
//        }
    }
}
