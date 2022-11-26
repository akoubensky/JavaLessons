/**
 * Очень простая нить.
 */
public class FirstThread extends Thread {

	public FirstThread(Runnable runnable) { super(runnable,
			"My first thread");
	}

//	@Override
//	public void run() {
//		System.out.println("Hello from " + getName());
//	}

}
