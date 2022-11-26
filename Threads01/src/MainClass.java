/**
 * Вводит следующие примитивы:
 * Thread (но еще есть и Runnable!)
 * r.run(), t.start, Thread.sleep(millis)
 * InterruptedException.
 * Есть еще Thread.currentThread(), getName.
 */
public class MainClass {

	public static void main(String args[]) {
		(new FirstThread(() ->
				System.out.println("Hello from Runnable")))
			.start();
		System.out.println("Hello from " + Thread.currentThread().getName());
	}

}
