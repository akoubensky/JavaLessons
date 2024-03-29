import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ��������� �������� � ������� �������� ����������� �����.
 * ���� ����������� ������������ ������ ���������������� ���������� �����,
 * ������� �������� ����������� �� �������. 
 */
public class SingleExecutorTest {
	/**
	 * ��������� ���������� �������� ������.
	 * �������� ����� � ���������� � ���� ���� ���������.
	 */
	private static class MyProcess implements Runnable {
		final int number;

		public MyProcess(int n) { number = n; }

		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.format("Thread: %s; Process: %d; Iteration: %d%n",
						Thread.currentThread().getName(), number, i);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// ������� �����������.
		ExecutorService executor = Executors.newSingleThreadExecutor();

		// ��������� ��� ������.
		for (int i = 0; i < 25; i++) {
			executor.execute(new MyProcess(i));
		}
		System.out.println("��� �������� ������� � ��������");

		// ����������� ��������� ���������� �����.
		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println("���������� ���� ����� ���������");
	}
}
