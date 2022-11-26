/**
 * Запускает два независимых процесса, работающих с одной и той же очередью.
 */
public class SyncQueueLauncher {
	public static void main(String[] args) {
		final SyncQueue queue = new SyncQueue();

		// Поток, записывающий 10000 элементов в очередь
		Thread supplier = new Thread(() -> {
			for (int i = 1; i <= 10000; i++) {
				while (queue.size() > 50)
					try { Thread.sleep(1); } catch (InterruptedException e) {}
				if (i % 1000 == 0) {
					System.out.println("Added: " + i);
				}
				queue.offer(i);
			}
		});

		// Поток, считывающий 10000 элементов из очереди. Зависает на пустой очереди
		// до тех пор, пока в ней не появится хотя бы один элемент.
		Thread consumer = new Thread(() -> {
			for (int i = 1; i <= 10000; i++) {
				while (queue.isEmpty())
					try { Thread.sleep(1); } catch (InterruptedException e) {}
				int ii = queue.poll();
				if (ii % 1000 == 0) {
					System.out.println("Extracted: " + i);
				}
			}
		});

		consumer.start();
		supplier.start();
	}
}
