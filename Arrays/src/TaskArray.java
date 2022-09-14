import java.util.Arrays;

public class TaskArray {
//TODO    ������: ����������� ������, �������(������) ������ ����, �������� ������ �� �����
    private static void func1(int [] table) {
        int size = table.length;
        for (int i=0; i< size/2;i++) {
            int n=table[i];
            table[i]=table[size-1-i];
            table[size-1-i]=n;
        }
    }
//TODO    ������: �������� ������� ������� �������� ��� �� ��� arrays equals (����) ������� ��������
//        2� ������� �� ����� � �������� ��������� � ���������� �� �� ���������.

    private static boolean func2 (int [] table1,int [] table2) {
        if (table1.length!=table2.length) return false;
        int size = table1.length;
        for (int i=0;i<size;i++) {
            if (table1[i]!=table2[i]) return false;
        }
        return true;
    }

//TODO  ������: ������� getMax �������� ������������ �������� �� ������� (2� ��������� ������ �� �����
//      � �����(����������� ������������ ���������)), �������� � �� ������. ������ ������ �� ������.

    private static int[] getMax (int[] table, int x) {
        int [] tableX=new int[x];
        int size = table.length;
        int[] tablex = Arrays.copyOf(table, table.length);

        for (int a = 1; a < size; a++) {
            for (int b = size - 1; b >= a; b--) {
                if (tablex[b - 1] < tablex[b]) {
                    int t = tablex[b - 1];
                    tablex[b - 1] = tablex[b];
                    tablex[b] = t;
                }
            }
        }
        for (int i =0;i<x;i++) {
            tableX[i]=tablex[i];
        }
        return tableX;
    }
//TODO  ���������� ������ getMax

    private static int[] getMax1 (int[] table, int x) {
        int[] tableX = new int[x];
        int size = table.length;
        int[] tablex = Arrays.copyOf(table, table.length);
        int c=0;

        for (int a=0;a<x;a++) {
            for (int b = a; b < size; b++) {
                if (tableX[a]<tablex[b]) {
                    tableX[a]=tablex[b];
                    c=b;
                }
            }
            tablex[c]=tablex[a];
            tablex[a]=tableX[a];
        }
        return tableX;
    }

    /**
     * ��� ������� ������� - �.�.
     * @param table �������� ������
     * @param x     ���������� ���������, �������� x < table.length
     * @return      ���������
     */
    private static int[] getMax2(int[] table, int x) {
        // ������ x ���������
        int[] result = Arrays.copyOf(table, x);
        // ��������� ��. ����� � ���������
//        Arrays.sort(result);
//        for (int i = x; i < table.length; i++) {
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i = 0; i < table.length; i++) {
            int element = table[i];
            if (element > result[0]) {
                // ��������� ����� ������� � ������������� ������
                int j = 1;
                while (j < x && result[j] < element) {
                    // �������� ��������
                    result[j-1] = result[j];
                    j++;
                }
                result[j-1] = element;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] table1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
        System.out.println(Arrays.toString(table1));
//      ������� ����� ��������� �������, ��� �� ��� �� ���������
        int[] table2 = Arrays.copyOf(table1, table1.length);


//TODO        ������� func1
        func1(table2);
        System.out.print("���������� ������ (func1): " + Arrays.toString(table2) + "\n"+"\n");

//TODO        ������� func2
        int[] table3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] table4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11};
        System.out.print("���������� (func2): "+func2(table1,table2)+" ");
        System.out.println(func2(table1,table3)+" "+func2(table1,table4)+"\n");

//TODO        ������� func getMax
        int [] tablegM={44,5,33,66,123,44,44,67,3,4,99,1,2,56,100};
        int[] getMax=getMax(tablegM,8);
        System.out.print("���������� ������ (getMax): " + Arrays.toString(getMax) + "\n"+"\n");

//TODO        ������� func getMax1
        int[] getMax1=getMax1(tablegM,9);
        System.out.print("���������� ������ (getMax1): " + Arrays.toString(getMax1) + "\n"+"\n");

        int[] getMax2=getMax2(tablegM,9);
        System.out.print("���������� ������ (getMax2): " + Arrays.toString(getMax1) + "\n"+"\n");

    }
}
