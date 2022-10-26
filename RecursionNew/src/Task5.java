/**
 * Ещё задачка на рекурсию:
 * Напишите рекурсивную функцию «переворачивания» строки, которая заданную строку преобразует так, что составляющие её
 * символы идут в обратном порядке. Например, строка «Привет!» будет преобразована в «!тевирП».
 * "Переворачивает" строку, записывая её символы в обратном порядке.
 *  * @param src   Исходная строка
 *  * @return      Перевёрнутая строка
 */

public class Task5 {

    static StringBuilder sb=new StringBuilder();
    public static String reverse(String src) {
       if (src.length()==0) {
           return sb.toString();
       }
       sb.append(src.charAt(src.length()-1));
       return reverse(src.substring(0,src.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
    }
}
// складывать значения ролученные от вызова каждой функции, как мы это делали, сделать с String

