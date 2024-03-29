import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;


public class MergeSort<T extends Comparable<T>> extends RecursiveAction {
	private static final long serialVersionUID = 2L;
	private static final int MIN_PARALLEL = 1000; 

	final private T[] array;		// ����������� ������
	final private int low, high;	// ������� � ������ ������� ������������ �������
	
	/**
	 * ����������� ������.
	 * 
	 * @param array
	 * @param from
	 * @param to
	 */
	public MergeSort(T[] array, int from, int to) {
		this.array = array;
		low = from;
		high = to;
	}
	
	@Override
	protected void compute() {
		if (high - low < MIN_PARALLEL) {
			Arrays.sort(array, low, high);
		} else {
			int mid = (low + high) / 2;
			MergeSort<T> t1 = new MergeSort<T>(array, low, mid);
			MergeSort<T> t2 = new MergeSort<T>(array, mid, high);
			invokeAll(t1, t2);
			merge(low, mid, high);
		}
	}
	
	private void merge(int low, int mid, int high) {
		T[] buf = Arrays.copyOfRange(array, low, mid);
		for (int ia = low, ib = 0, ic = mid; ia < high; ia++) {
			array[ia] =
				ic == high ? buf[ib++] :
				ib == mid - low ? array[ic++] :
				buf[ib].compareTo(array[ic]) < 0 ? buf[ib++] :
				array[ic++]; 
		}
	}

	/**
	 * �������� ����, ��� ������ ���������� �� �����������.
	 * 
	 * @param array	����������� ������
	 * @return		true, ���� ������ ����������, false � ��������� ������
	 */
	private static <T extends Comparable<T>> boolean test(T[] array) {
		for (int i = 0; i < array.length - 1; ++i) {
			if (array[i].compareTo(array[i+1]) > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		// ������� ������ �� ��������� ���������
		final int COUNT = 1_000_000;
		
		Random rnd = new Random();
		Integer[] array = new Integer[COUNT];
		for (int i = 0; i < COUNT; i++) array[i] = rnd.nextInt(2*COUNT);
		
		// ��������� "������������" ������ ���������� � ������� ���� Fork/Join �����
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("������������ ����������");
		long start = System.currentTimeMillis();
		pool.invoke(new MergeSort<Integer>(array, 0, COUNT));
		pool.shutdown();
		//pool.awaitTermination(1, TimeUnit.MINUTES);
		long elapsed = System.currentTimeMillis() - start;
		
		System.out.format("���������� ��������� %s �� %d �����������\n",
				test(array) ? "�������" : "� ��������", elapsed);
		
		for (int i = 0; i < COUNT; i++) array[i] = rnd.nextInt(2*COUNT);
		System.out.println("���������������� ����������");
		start = System.currentTimeMillis();
		Arrays.sort(array);
		elapsed = System.currentTimeMillis() - start;
		
		System.out.format("���������� ��������� %s �� %d �����������\n",
				test(array) ? "�������" : "� ��������", elapsed);
	}

}
