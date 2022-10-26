/**
 * ��� ������� �� ��������:
 * �������� ����������� ������� ����������������� ������, ������� �������� ������ ����������� ���, ��� ������������ �
 * ������� ���� � �������� �������. ��������, ������ �������!� ����� ������������� � �!�����ϻ.
 * "��������������" ������, ��������� � ������� � �������� �������.
 *  * @param src   �������� ������
 *  * @return      ����������� ������
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
// ���������� �������� ���������� �� ������ ������ �������, ��� �� ��� ������, ������� � String

